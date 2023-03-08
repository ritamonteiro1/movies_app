package com.example.featurepopularmovies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.featurepopularmovies.R

class PopularMoviesActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movies)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.popular_movies_container) as NavHostFragment
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.popular_movies_container)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, PopularMoviesActivity::class.java))
        }
    }
}