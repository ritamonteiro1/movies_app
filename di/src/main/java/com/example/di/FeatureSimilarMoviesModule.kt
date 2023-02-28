package com.example.di

import com.example.featuresimilarmovies.presentation.similarmovies.SimilarMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureSimilarMoviesModule = module {
    viewModel { SimilarMoviesViewModel(get()) }
}