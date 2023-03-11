package com.example.featurepopularmovies.presentation.moviedetails

import android.content.res.Configuration
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.theme.apptheme.MoviesAppTheme

@Composable
internal fun PopularMoviesDetailScreen(
    viewModel: PopularMovieDetailsViewModel
){
    ScreenContent()
}

@Composable
private fun ScreenContent() {
    Scaffold(topBar = { AppBarContent() }) {
        BodyContent()
    }
}

@Composable
private fun AppBarContent() {

}

@Composable
private fun BodyContent() {

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Preview
@Composable
private fun PreviewScreenContent() {
    MoviesAppTheme {
        ScreenContent()
    }
}