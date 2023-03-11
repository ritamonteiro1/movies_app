package com.example.featurepopularmovies.presentation.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.designsystem.theme.apptheme.MoviesAppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : Fragment() {
    private val viewModel: PopularMoviesViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MoviesAppTheme {
                    PopularMoviesScreen(viewModel = viewModel)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        lifecycle.coroutineScope.launch {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is PopularMoviesContract.Effect.NavigateToPopularMovieDetailsScreen -> {
                        navigateToPopularMovieDetailsFragment(effect.movieId)
                    }
                    is PopularMoviesContract.Effect.NavigateToFavoriteMoviesScreen -> {
                        navigateToFavoriteMoviesFragment()
                    }
                }
            }
        }
    }

    private fun navigateToFavoriteMoviesFragment() {
        val action =
            PopularMoviesFragmentDirections.actionPopularMoviesFragmentToFavoriteMoviesFragment()
        findNavController().navigate(action)
    }

    private fun navigateToPopularMovieDetailsFragment(movieId: Int) {
        val action =
            PopularMoviesFragmentDirections.actionPopularMoviesFragmentToPopularMovieDetailFragment(
                movieId = movieId
            )
        findNavController().navigate(action)
    }
}
