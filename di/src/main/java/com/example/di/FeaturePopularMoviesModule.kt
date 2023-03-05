package com.example.di

import com.example.featurepopularmovies.presentation.favoritemovies.FavoriteMoviesViewModel
import com.example.featurepopularmovies.presentation.moviedetails.PopularMovieDetailsViewModel
import com.example.featurepopularmovies.presentation.popularmovies.PopularMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featurePopularMoviesModule = module {
    viewModel { PopularMoviesViewModel(get()) }
    viewModel { PopularMovieDetailsViewModel(get()) }
    viewModel { FavoriteMoviesViewModel(get()) }
}