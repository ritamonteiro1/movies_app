package com.example.data.local.datasource

import androidx.room.*
import com.example.data.local.models.MovieDetailCache

interface PopularMoviesCacheDataSource {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: MovieDetailCache)

    @Query("DELETE FROM movieDetailCache WHERE id = :id")
    suspend fun deleteMovie(id: Int)

    @Query("SELECT * FROM movieDetailCache")
    suspend fun getFavoriteMovies(): List<MovieDetailCache>
}

@Database(entities = [MovieDetailCache::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun movieDetailsCache(): MovieDetailCache
}