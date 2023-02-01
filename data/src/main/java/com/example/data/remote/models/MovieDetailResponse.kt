package com.example.data.remote.models


import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("backdrop_path") val backdropPath: String?,
    val genres: List<GenreResponse>?,
    val id: Int?,
    val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
    val title: String?,
    @SerializedName("vote_average") val voteAverage: Double?,
)