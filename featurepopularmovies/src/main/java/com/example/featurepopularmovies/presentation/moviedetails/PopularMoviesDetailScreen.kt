package com.example.featurepopularmovies.presentation.moviedetails

import android.content.res.Configuration
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.theme.apptheme.MoviesAppTheme
import com.example.designsystem.theme.apptheme.MoviesTheme

@Composable
internal fun PopularMoviesDetailScreen(
    viewModel: PopularMovieDetailsViewModel,
    onBackPressed: () -> Unit,
) {
    ScreenContent(onBackPressed = onBackPressed)
}

@Composable
private fun ScreenContent(
    onBackPressed: () -> Unit,
) {
    Scaffold(topBar = { AppBarContent(onBackPressed = onBackPressed) }) {
        BodyContent()
    }
}

@Composable
private fun AppBarContent(
    onBackPressed: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = "Movie Detail Screen") },
        backgroundColor = MoviesTheme.colors.moviesColors.primary,
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = ""
                )
            }
        }
    )
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
        ScreenContent(onBackPressed = {})
    }
}