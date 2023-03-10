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
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val API_KEY = "ad1bac056f5624a4c3f693ddf6075e6b"
private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val DATABASE_NAME = "movies.db"

val dataModule = module {
    single {
        okHttpClient()
    }

    single<Gson> {
        GsonBuilder().create()
    }

    single {
        retrofit(get(), get()).create(PopularMoviesService::class.java)
    }

    single {
        retrofit(get(), get()).create(SimilarMoviesService::class.java)
    }

    single<PopularMoviesRemoteDataSource> {
        PopularMoviesRemoteDataSourceImpl(get())
    }

    single<SimilarMoviesRemoteDataSource> {
        SimilarMoviesRemoteDataSourceImpl(get())
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDataBase::class.java, DATABASE_NAME
        ).build()
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

private fun retrofit(okHttpClient: OkHttpClient, gson: Gson) = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .client(okHttpClient)
    .build()

private fun okHttpClient() = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    })
    .addInterceptor { chain ->
        val originalRequest = chain.request()
        val newUrl = originalRequest.url.newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }
    .build()
