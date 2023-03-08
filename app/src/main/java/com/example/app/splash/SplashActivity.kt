package com.example.app.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.moviesapp.R
import com.example.navigation.PopularMoviesBoundary
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject

class SplashActivity : ComponentActivity() {
    private val boundary: PopularMoviesBoundary by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycleScope.launchWhenCreated {
            delay(3000L)
            boundary.navigateToFeaturePopularMovies(this@SplashActivity)
            //  finish()
        }
    }
}