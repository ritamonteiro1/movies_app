package com.example.featurepopularmovies.presentation.popularmovies

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.designsystem.theme.apptheme.MoviesAppTheme
import com.example.designsystem.theme.apptheme.MoviesTheme
import com.example.designsystem.widgets.CardItem
import com.example.designsystem.widgets.CardText
import com.example.designsystem.widgets.LabeledCard
import com.example.featurepopularmovies.R
import com.example.featurepopularmovies.domain.models.PopularMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
internal fun PopularMoviesScreen(
    viewModel: PopularMoviesViewModel,
) {
    viewModel.handleEvent(PopularMoviesContract.Event.GetPopularMovies)
    val state by viewModel.state.collectAsState()
    ScreenContent(state = state, onClickCard = { movieId ->
        viewModel.handleEvent(PopularMoviesContract.Event.OnClickMovieCard(movieId))
    })
}

@Composable
private fun ScreenContent(
    state: PopularMoviesContract.State,
    onClickCard: (Int) -> Unit,
) {
    Scaffold(
        topBar = { AppBarContent() }) {
        when (state) {
            is PopularMoviesContract.State.Success -> {
                val items = state.popularMovies
                BodyContent(
                    items = items,
                    onClickCard = onClickCard
                )
            }
            else -> {}
        }
    }
}

@Composable
private fun AppBarContent() {
    TopAppBar(backgroundColor = MoviesTheme.colors.moviesColors.primary) {}
}

@Composable
private fun BodyContent(
    items: Flow<PagingData<PopularMovie>>,
    onClickCard: (Int) -> Unit,
) {
    val lazyItems: LazyPagingItems<PopularMovie> = items.collectAsLazyPagingItems()

    when (lazyItems.loadState.refresh) {
        is LoadState.Loading -> {
            // Show loading
        }
        is LoadState.Error -> {
            // Show error
        }
        is LoadState.NotLoading -> {
            LazyColumn {
                itemsIndexed(lazyItems) { _, item ->
                    if (item != null) {
                        LabeledCard(
                            cardItems = CardItem(
                                image = item.posterPath.toMoviePosterUrl(),
                                texts = listOf(
                                    CardText(
                                        title = stringResource(id = R.string.title_movie),
                                        subtitle = item.title
                                    ),
                                    CardText(
                                        title = stringResource(id = R.string.release_movie),
                                        subtitle = item.releaseDate
                                    ),
                                    CardText(
                                        title = stringResource(id = R.string.vote_movie),
                                        subtitle = item.voteAverage.toString()
                                    ),
                                    CardText(
                                        title = stringResource(id = R.string.overview_movie),
                                        subtitle = item.overview
                                    ),
                                )
                            )
                        ) {
                            onClickCard(item.id)
                        }
                    }
                }
            }
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Preview
@Composable
private fun PreviewScreenContent() {
    MoviesAppTheme {
        ScreenContent(
            state = PopularMoviesContract.State.Success(emptyFlow()),
            onClickCard = {},
        )
    }
}

fun String.toMoviePosterUrl(): String {
    return "https://image.tmdb.org/t/p/w500/$this"
}