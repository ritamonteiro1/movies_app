package com.example.featuresimilarmovies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.featuresimilarmovies.R

class SimilarMoviesActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_similar_movies)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.similar_movies_container) as NavHostFragment
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.similar_movies_container)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    companion object {
        fun launch(context: Context, movieId: Int) {
            context.startActivity(Intent(context, SimilarMoviesActivity::class.java).apply {
                putExtra("movieId", movieId)
            })
        }
    }
}