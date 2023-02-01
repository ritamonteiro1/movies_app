package com.example.data.mappers

import com.example.data.remote.models.MovieDetailResponse
import com.example.data.remote.models.MovieListResponse
import com.example.data.remote.models.MovieResponse
import com.example.featurepopularmovies.domain.models.PopularMovie
import com.example.featurepopularmovies.domain.models.PopularMovieDetail
import com.example.featurepopularmovies.domain.models.PopularMovieList
import com.example.featuresimilarmovies.domain.models.SimilarMovie
import com.example.featuresimilarmovies.domain.models.SimilarMovieList

object Default {
    const val INT = -1
    const val DOUBLE = -1.0
}

fun MovieListResponse.toPopularDomain(): PopularMovieList {
    return PopularMovieList(
        page = page ?: Default.INT,
        movieList = movieList?.map { it.toPopularDomain() }.orEmpty(),
        totalPages = totalPages ?: Default.INT,
    )
}

fun MovieResponse.toPopularDomain(): PopularMovie {
    return PopularMovie(
        id = id ?: Default.INT,
        title = title.orEmpty(),
        overview = overview.orEmpty(),
        posterPath = posterPath.orEmpty(),
        backdropPath = backdropPath.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        voteAverage = voteAverage ?: Default.DOUBLE,
    )
}

fun MovieDetailResponse.toPopularDomain(): PopularMovieDetail {
    return PopularMovieDetail(
        backdropPath = backdropPath.orEmpty(),
        genres = genres?.map { it.name.orEmpty() }.orEmpty(),
        id = id ?: Default.INT,
        overview = overview.orEmpty(),
        posterPath = posterPath.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        title = title.orEmpty(),
        voteAverage = voteAverage ?: Default.DOUBLE,
    )
}

fun MovieListResponse.toSimilarDomain(): SimilarMovieList {
    return SimilarMovieList(
        page = page ?: Default.INT,
        movieList = movieList?.map { it.toSimilarDomain() }.orEmpty(),
        totalPages = totalPages ?: Default.INT,
    )
}

fun MovieResponse.toSimilarDomain(): SimilarMovie {
    return SimilarMovie(
        id = id ?: Default.INT,
        title = title.orEmpty(),
        overview = overview.orEmpty(),
        posterPath = posterPath.orEmpty(),
        backdropPath = backdropPath.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        voteAverage = voteAverage ?: Default.DOUBLE,
    )
}
