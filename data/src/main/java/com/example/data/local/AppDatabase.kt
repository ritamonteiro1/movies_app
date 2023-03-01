package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.datasource.PopularMoviesCacheDataSource
import com.example.data.local.models.MovieDetailCache

@Database(entities = [MovieDetailCache::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun movieDetailsCache(): PopularMoviesCacheDataSource
}