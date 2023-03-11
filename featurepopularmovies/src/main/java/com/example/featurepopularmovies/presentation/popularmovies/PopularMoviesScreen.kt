package com.example.featurepopularmovies.presentation.popularmovies

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
    val state by viewModel.state.collectAsState()
    ScreenContent(
        state = state,
        onClickMovieCard = { movieId ->
            viewModel.handleEvent(PopularMoviesContract.Event.OnClickMovieCard(movieId))
        },
        onClickSeeFavorites = {
            viewModel.handleEvent(PopularMoviesContract.Event.OnClickSeeFavorites)
        })
}

@Composable
private fun ScreenContent(
    state: PopularMoviesContract.State,
    onClickMovieCard: (Int) -> Unit,
    onClickSeeFavorites: () -> Unit = {},
) {
    Scaffold(
        topBar = { AppBarContent(onClickSeeFavorites = onClickSeeFavorites) }) {
        when (state) {
            is PopularMoviesContract.State.Success -> {
                val items = state.popularMovies
                BodyContent(
                    items = items,
                    onClickMovieCard = onClickMovieCard
                )
            }
            is PopularMoviesContract.State.Loading -> {
                // TODO(initial)
            }
            is PopularMoviesContract.State.Error -> {
                // TODO(error)
            }
        }
    }
}

@Composable
private fun AppBarContent(
    onClickSeeFavorites: () -> Unit = {},
) {
    TopAppBar(
        title = { Text(text = "") },
        backgroundColor = MoviesTheme.colors.moviesColors.primary,
        actions = {
            IconButton(onClick = onClickSeeFavorites) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "",
                )
            }
        }
    )
}

@Composable
private fun BodyContent(
    items: Flow<PagingData<PopularMovie>>,
    onClickMovieCard: (Int) -> Unit,
) {
    val lazyItems: LazyPagingItems<PopularMovie> = items.collectAsLazyPagingItems()

    when (lazyItems.loadState.refresh) {
        is LoadState.Loading -> {
            // TODO(loading)
        }
        is LoadState.Error -> {
            // TODO(error)
        }
        is LoadState.NotLoading -> {
            MovieList(lazyItems, onClickMovieCard)
        }
    }
}

@Composable
private fun MovieList(
    lazyItems: LazyPagingItems<PopularMovie>,
    onClickCard: (Int) -> Unit
) {
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


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Preview
@Composable
private fun PreviewScreenContent() {
    MoviesAppTheme {
        ScreenContent(
            state = PopularMoviesContract.State.Success(emptyFlow()),
            onClickMovieCard = {},
        )
    }
}

fun String.toMoviePosterUrl(): String {
    return "https://image.tmdb.org/t/p/w500/$this"
}