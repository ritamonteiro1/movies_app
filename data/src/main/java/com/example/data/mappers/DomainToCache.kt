package com.example.data.mappers

import com.example.data.local.models.MovieDetailCache
import com.example.featurepopularmovies.domain.models.PopularMovieDetail

fun PopularMovieDetail.toPopularCache(): MovieDetailCache {
    return MovieDetailCache(
        backdropPath = backdropPath,
        genres = genres.map { it },
        id = id,
        overview = overview,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        isFavorite = isFavorite,
    )
}