package com.example.data.models

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    val page: Int?,
    @SerializedName("results") val movieList: List<MovieResponse>?,
    @SerializedName("total_page") val totalPages: Int?,
)