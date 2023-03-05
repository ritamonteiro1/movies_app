package com.example.navigation

import android.content.Context

interface SimilarMoviesBoundary {
    fun navigateToFeatureSimilarMovies(context: Context, movieId: Int)
}