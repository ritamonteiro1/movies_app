package com.example.featuresimilarmovies.domain.models

data class SimilarMovieDetail(
    val backdropPath: String,
    val genres: List<String>,
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
)
