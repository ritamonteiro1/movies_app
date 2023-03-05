package com.example.data.local.datasource

import androidx.room.*
import com.example.data.local.models.MovieDetailCache

@Dao
interface PopularMoviesCacheDataSource {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: MovieDetailCache)

    @Query("DELETE FROM movieDetailCache WHERE id = :id")
    suspend fun deleteMovie(id: Int)

    @Query("SELECT * FROM movieDetailCache")
    suspend fun getFavoriteMovies(): List<MovieDetailCache>
}
