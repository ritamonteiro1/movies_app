package com.example.featurepopularmovies.domain.repository

import androidx.paging.PagingData
import com.example.core.utils.Result
import com.example.featurepopularmovies.domain.models.PopularMovie
import com.example.featurepopularmovies.domain.models.PopularMovieDetail
import kotlinx.coroutines.flow.Flow

interface PopularMoviesRepository {
    fun getPopularMovies(): Flow<PagingData<PopularMovie>>
    suspend fun getPopularMovieDetails(movieId: Int): Result<PopularMovieDetail>
}