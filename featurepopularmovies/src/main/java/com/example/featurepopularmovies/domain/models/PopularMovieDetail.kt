package com.example.featurepopularmovies.domain.models

data class PopularMovieDetail(
    val backdropPath: String,
    val genres: List<String>,
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val isFavorite: Boolean = false,
)
