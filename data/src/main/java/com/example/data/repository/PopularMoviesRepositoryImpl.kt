package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.core.utils.Result
import com.example.data.local.datasource.PopularMoviesCacheDataSource
import com.example.data.mappers.toPopularCache
import com.example.data.mappers.toPopularDomain
import com.example.data.pagingsource.PopularMoviePagingSource
import com.example.data.remote.datasource.PopularMoviesRemoteDataSource
import com.example.featurepopularmovies.domain.models.PopularMovie
import com.example.featurepopularmovies.domain.models.PopularMovieDetail
import com.example.featurepopularmovies.domain.repository.PopularMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PopularMoviesRepositoryImpl(
    private val remoteDataSource: PopularMoviesRemoteDataSource,
    private val cacheDataSource: PopularMoviesCacheDataSource
) : PopularMoviesRepository {

    override fun getPopularMovies(): Flow<PagingData<PopularMovie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PopularMoviePagingSource(remoteDataSource) }
        ).flow.map {
            it.map { movieResponse -> movieResponse.toPopularDomain() }
        }
    }

    override suspend fun getPopularMovieDetails(movieId: Int): Result<PopularMovieDetail> {
        return when (val result = remoteDataSource.getMovieDetails(movieId)) {
            is Result.Success -> {
                Result.Success(result.data.toPopularDomain())
            }
            is Result.Error -> {
                Result.Error(result.error)
            }
        }
    }

    override suspend fun getFavoriteMovies(): List<PopularMovieDetail> {
        return cacheDataSource.getFavoriteMovies().map { movie ->
            movie.toPopularDomain()
        }
    }

    override suspend fun saveFavoriteMovie(movie: PopularMovieDetail) {
        cacheDataSource.saveMovie(movie.toPopularCache())
    }

    override suspend fun deleteFavoriteMovie(movieId: Int) {
        cacheDataSource.deleteMovie(movieId)
    }

}