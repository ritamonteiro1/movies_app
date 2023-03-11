package com.example.featurepopularmovies.presentation.popularmovies

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.coreui.viewmodel.BaseViewModel
import com.example.coreui.viewmodel.EffectUi
import com.example.coreui.viewmodel.EventUi
import com.example.coreui.viewmodel.StateUi
import com.example.featurepopularmovies.domain.models.PopularMovie
import com.example.featurepopularmovies.domain.repository.PopularMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PopularMoviesViewModel(
    private val repository: PopularMoviesRepository,
) : BaseViewModel<PopularMoviesContract.Event, PopularMoviesContract.State, PopularMoviesContract.Effect>() {

    override fun createInitialState(): PopularMoviesContract.State {
        return PopularMoviesContract.State.Loading
    }

    override fun handleEvent(event: PopularMoviesContract.Event) {
        when (event) {
            is PopularMoviesContract.Event.GetPopularMovies -> {
                val popularMoviesFlow = getPopularMovies()
                setState(PopularMoviesContract.State.Success(popularMoviesFlow))
            }
            is PopularMoviesContract.Event.OnClickMovieCard -> {
                viewModelScope.launch {
                    onClickMovieCard(event)
                }
            }
        }
    }

    private suspend fun onClickMovieCard(
        event: PopularMoviesContract.Event.OnClickMovieCard
    ) {
        setEffect(
            PopularMoviesContract.Effect.NavigateToPopularMovieDetailsFragment(
                event.movieId
            )
        )
    }

    private fun getPopularMovies(): Flow<PagingData<PopularMovie>> {
        return repository.getPopularMovies().cachedIn(viewModelScope)
    }

}

object PopularMoviesContract {
    sealed interface Event : EventUi {
        object GetPopularMovies : Event
        data class OnClickMovieCard(val movieId: Int) : Event
    }

    sealed interface Effect : EffectUi {
        data class NavigateToPopularMovieDetailsFragment(val movieId: Int) : Effect
    }

    sealed interface State : StateUi {
        object Loading : State
        data class Success(val popularMovies: Flow<PagingData<PopularMovie>>) : State
        data class Error(val error: Throwable) : State
    }
}