package com.example.data.remote.datasource

import com.example.core.utils.Result
import com.example.data.remote.api.PopularMoviesService
import com.example.data.remote.models.MovieDetailResponse
import com.example.data.remote.models.MovieListResponse
import com.example.data.remote.utils.dataWrapper

interface PopularMoviesRemoteDataSource {
    suspend fun getPopularMovies(page: Int) : Result<MovieListResponse>
    suspend fun getMovieDetails(movieId: Int) : Result<MovieDetailResponse>
}

class PopularMoviesRemoteDataSourceImpl(
    private val service: PopularMoviesService
) : PopularMoviesRemoteDataSource {
    override suspend fun getPopularMovies(page: Int): Result<MovieListResponse> {
        return dataWrapper {
            service.getPopularMovies(page)
        }
    }

    override suspend fun getMovieDetails(movieId: Int): Result<MovieDetailResponse> {
        return dataWrapper {
            service.getMovieDetails(movieId)
        }
    }
}