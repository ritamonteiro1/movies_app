package com.example.app.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.moviesapp.R
import com.example.navigation.PopularMoviesBoundary
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {
    private val boundary: PopularMoviesBoundary by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycleScope.launchWhenCreated {
            delay(ANIMATION_DURATION)
            boundary.navigateToFeaturePopularMovies(this@SplashActivity)
            finish()
        }
    }

    private companion object {
        const val ANIMATION_DURATION = 3000L
    }
}