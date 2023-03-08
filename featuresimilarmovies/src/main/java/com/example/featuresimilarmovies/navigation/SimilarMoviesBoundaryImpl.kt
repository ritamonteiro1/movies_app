package com.example.featuresimilarmovies.navigation

import android.content.Context
import com.example.featuresimilarmovies.presentation.SimilarMoviesActivity
import com.example.navigation.SimilarMoviesBoundary

class SimilarMoviesBoundaryImpl : SimilarMoviesBoundary {
    override fun navigateToFeatureSimilarMovies(context: Context, movieId: Int) {
        SimilarMoviesActivity.launch(context, movieId)
    }
}