package com.example.data.remote.datasource

import com.example.core.utils.Result
import com.example.data.remote.api.SimilarMoviesService
import com.example.data.remote.models.MovieListResponse
import com.example.data.remote.utils.dataWrapper

interface SimilarMoviesRemoteDataSource {
    suspend fun getSimilarMovies(movieId: Int) : Result<MovieListResponse>
}

class SimilarMoviesRemoteDataSourceImpl(
    private val service: SimilarMoviesService
) : SimilarMoviesRemoteDataSource {
    override suspend fun getSimilarMovies(movieId: Int): Result<MovieListResponse> {
        return dataWrapper {
            service.getSimilarMovies(movieId)
        }
    }
}