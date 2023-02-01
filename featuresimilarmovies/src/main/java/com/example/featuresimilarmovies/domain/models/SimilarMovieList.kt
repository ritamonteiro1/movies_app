package com.example.featuresimilarmovies.domain.models

data class SimilarMovieList(
    val page: Int,
    val movieList: List<SimilarMovie>,
    val totalPages: Int,
)
