package com.example.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieDetailCache(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val backdropPath: String,
    val genres: List<String>,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val isFavorite: Boolean = true,
)
