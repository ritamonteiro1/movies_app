package com.example.featuresimilarmovies.domain.repository

import com.example.core.utils.Result
import com.example.featuresimilarmovies.domain.models.SimilarMovieList

interface SimilarMoviesRepository {
    suspend fun getSimilarMovies(movieId: Int): Result<SimilarMovieList>
}