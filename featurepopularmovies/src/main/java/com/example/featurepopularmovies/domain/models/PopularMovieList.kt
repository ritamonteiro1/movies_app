package com.example.featurepopularmovies.domain.models

data class PopularMovieList(
    val page: Int,
    val movieList: List<PopularMovie>,
    val totalPages: Int,
)
