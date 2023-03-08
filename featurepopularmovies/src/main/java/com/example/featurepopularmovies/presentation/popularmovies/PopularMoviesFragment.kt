package com.example.featurepopularmovies.presentation.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
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
import com.example.featurepopularmovies.domain.models.PopularMovie
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : Fragment() {
    private val viewModel: PopularMoviesViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.handleEvent(PopularMoviesContract.Event.GetPopularMovies)

        return ComposeView(requireContext()).apply {
            setContent {
                MoviesAppTheme {
                    ScreenContent()
                }
            }
        }
    }

    @Composable
    private fun ScreenContent() {
        Scaffold(topBar = { AppBarContent() }) {
            val moviesState by viewModel.state.collectAsState()

            when (moviesState) {
                is PopularMoviesContract.State.Success -> {
                    val items = (moviesState as PopularMoviesContract.State.Success).popularMovies
                    BodyContent(items)
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
    private fun BodyContent(items: Flow<PagingData<PopularMovie>>) {
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
                    itemsIndexed(lazyItems) { index, item ->
                        if (item != null) {
                            LabeledCard(
                                cardItems = CardItem(
                                    image = item.posterPath.toMoviePosterUrl(),
                                    texts = listOf(
                                        CardText(
                                            title = "Title",
                                            subtitle = item.title
                                        ),
                                        CardText(
                                            title = "Subtitle",
                                            subtitle = item.releaseDate
                                        ),
                                        CardText(
                                            title = "Vote Average",
                                            subtitle = item.voteAverage.toString()
                                        ),
                                        CardText(
                                            title = "Overview",
                                            subtitle = item.overview
                                        ),
                                    )
                                )
                            ) {

                            }
                        }
                    }
                }
            }
        }


    }

    @Preview
    @Composable
    private fun PreviewScreenContent() {
        MoviesAppTheme {
            ScreenContent()
        }
    }
}

fun String.toMoviePosterUrl(): String {
    return "https://image.tmdb.org/t/p/w500/$this"
}
