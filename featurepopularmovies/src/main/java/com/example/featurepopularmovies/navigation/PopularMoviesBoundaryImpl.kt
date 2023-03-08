package com.example.featurepopularmovies.navigation

import android.content.Context
import com.example.featurepopularmovies.presentation.PopularMoviesActivity
import com.example.navigation.PopularMoviesBoundary

class PopularMoviesBoundaryImpl : PopularMoviesBoundary {
    override fun navigateToFeaturePopularMovies(context: Context) {
        PopularMoviesActivity.launch(context)
    }
}