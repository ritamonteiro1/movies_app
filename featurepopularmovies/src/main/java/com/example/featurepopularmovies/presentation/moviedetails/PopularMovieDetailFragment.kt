package com.example.featurepopularmovies.presentation.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.navArgs
import com.example.designsystem.theme.apptheme.MoviesAppTheme
import com.example.featurepopularmovies.presentation.favoritemovies.FavoriteMoviesContract
import com.example.navigation.SimilarMoviesBoundary
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMovieDetailFragment : Fragment() {
    private val boundary: SimilarMoviesBoundary by inject()
    private val viewModel: PopularMovieDetailsViewModel by viewModel()
    private val navArgs: PopularMovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MoviesAppTheme {
                    PopularMoviesDetailScreen(viewModel = viewModel)
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
            viewModel.effect.collect() { effect ->
                when (effect) {
                    is PopularMovieDetailsContract.Effect.FavoriteMovieDeleted -> TODO()
                    is PopularMovieDetailsContract.Effect.FavoriteMovieSaved -> TODO()
                }
            }
        }
    }
}