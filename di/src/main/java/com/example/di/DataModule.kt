package com.example.di

import androidx.room.Room
import com.example.data.local.AppDataBase
import com.example.data.remote.api.PopularMoviesService
import com.example.data.remote.api.SimilarMoviesService
import com.example.data.remote.datasource.PopularMoviesRemoteDataSource
import com.example.data.remote.datasource.PopularMoviesRemoteDataSourceImpl
import com.example.data.remote.datasource.SimilarMoviesRemoteDataSource
import com.example.data.remote.datasource.SimilarMoviesRemoteDataSourceImpl
import com.example.data.repository.PopularMoviesRepositoryImpl
import com.example.data.repository.SimilarMoviesRepositoryImpl
import com.example.featurepopularmovies.domain.repository.PopularMoviesRepository
import com.example.featuresimilarmovies.domain.repository.SimilarMoviesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Constants {
    const val API_KEY = "ad1bac056f5624a4c3f693ddf6075e6b"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val DATABASE_NAME = "movies.db"
}

val dataModule = module {
    single {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor {
            val originalRequest = it.request()

            val urlWithApiKey = originalRequest.url.newBuilder()
                .addQueryParameter("api_key", Constants.API_KEY)
                .build()

            val requestWithApiKey = originalRequest.newBuilder()
                .url(urlWithApiKey)
                .build()

            it.proceed(requestWithApiKey)

            val request = it.request().url.newBuilder().addQueryParameter(
                "api_key", Constants.API_KEY,
            ).build()
            it.proceed(it.request().newBuilder().url(request).build())
        }
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        builder.interceptors().add(loggingInterceptor)
    }

    single {
        GsonConverterFactory.create()
    }

    single {
        val baseBuilder = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(get())
            .client(get())
            .build()

        baseBuilder.create(PopularMoviesService::class.java)
        baseBuilder.create(SimilarMoviesService::class.java)
    }

    single<PopularMoviesRemoteDataSource> {
        PopularMoviesRemoteDataSourceImpl(get())
    }

    single<SimilarMoviesRemoteDataSource> {
        SimilarMoviesRemoteDataSourceImpl(get())
    }

    single {
        Room.databaseBuilder(get(), AppDataBase::class.java, Constants.DATABASE_NAME).build()
    }

    single {
        get<AppDataBase>().movieDetailsCache()
    }

    single<PopularMoviesRepository> {
        PopularMoviesRepositoryImpl(get(), get())
    }

    single<SimilarMoviesRepository> {
        SimilarMoviesRepositoryImpl(get())
    }
}
