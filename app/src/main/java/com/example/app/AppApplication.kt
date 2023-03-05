package com.example.app

import android.app.Application
import com.example.di.dataModule
import com.example.di.featurePopularMoviesModule
import com.example.di.featureSimilarMoviesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@AppApplication)
            modules(
                listOf(
                    dataModule,
                    featureSimilarMoviesModule,
                    featurePopularMoviesModule,
                )
            )
        }
    }
}