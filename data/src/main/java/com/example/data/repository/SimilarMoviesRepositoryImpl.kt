package com.example.data.repository

import com.example.core.utils.Result
import com.example.data.mappers.toSimilarDomain
import com.example.data.remote.datasource.SimilarMoviesRemoteDataSource
import com.example.featuresimilarmovies.domain.models.SimilarMovieList
import com.example.featuresimilarmovies.domain.repository.SimilarMoviesRepository

class SimilarMoviesRepositoryImpl(
    private val remoteDataSource: SimilarMoviesRemoteDataSource
) : SimilarMoviesRepository {
    override suspend fun getSimilarMovies(movieId: Int): Result<SimilarMovieList> {
        return when (val result = remoteDataSource.getSimilarMovies(movieId)) {
            is Result.Success -> Result.Success(result.data.toSimilarDomain())
            is Result.Error -> Result.Error(result.error)
        }
    }
}