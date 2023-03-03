package com.example.featurepopularmovies.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.featurepopularmovies.R

class PopularMoviesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movies)
    }
}