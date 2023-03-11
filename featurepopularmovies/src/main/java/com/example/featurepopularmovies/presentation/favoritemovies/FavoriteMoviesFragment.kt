package com.example.featurepopularmovies.presentation.favoritemovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.designsystem.theme.apptheme.MoviesAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteMoviesFragment : Fragment() {
    private val viewModel: FavoriteMoviesViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MoviesAppTheme {
                    FavoriteMoviesScreen(
                        viewModel = viewModel,
                        onBackPressed = { findNavController().popBackStack() },
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.handleEvent(FavoriteMoviesContract.Event.GetFavoriteMovies)
        setupObservers()
    }

    private fun setupObservers() {

    }
}