package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.local.datasource.PopularMoviesCacheDataSource
import com.example.data.local.models.MovieDetailCache
import com.example.data.local.models.StringListConverter

@Database(entities = [MovieDetailCache::class], version = 1)
@TypeConverters(StringListConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun movieDetailsCache(): PopularMoviesCacheDataSource
}