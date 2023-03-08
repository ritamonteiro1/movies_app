package com.example.featuresimilarmovies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.featuresimilarmovies.R

class SimilarMoviesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_similar_movies)
    }

    companion object {
        fun launch(context: Context, movieId: Int) {
            val intent = Intent(context, SimilarMoviesActivity::class.java)
            intent.putExtra("movieId", movieId)
            startActivity(context, intent, null)
        }
    }
}