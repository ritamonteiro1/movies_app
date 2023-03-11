package com.example.featurepopularmovies.presentation.favoritemovies

import androidx.lifecycle.viewModelScope
import com.example.coreui.viewmodel.BaseViewModel
import com.example.coreui.viewmodel.EffectUi
import com.example.coreui.viewmodel.EventUi
import com.example.coreui.viewmodel.StateUi
import com.example.featurepopularmovies.domain.models.PopularMovieDetail
import com.example.featurepopularmovies.domain.repository.PopularMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class FavoriteMoviesViewModel(
    private val repository: PopularMoviesRepository,
    private val dispatcher: CoroutineContext = Dispatchers.Main
) : BaseViewModel<FavoriteMoviesContract.Event, FavoriteMoviesContract.State, FavoriteMoviesContract.Effect>() {

    override fun createInitialState(): FavoriteMoviesContract.State {
        return FavoriteMoviesContract.State.Loading
    }

    override fun handleEvent(event: FavoriteMoviesContract.Event) {
        viewModelScope.launch(dispatcher) {
            when (event) {
                is FavoriteMoviesContract.Event.GetFavoriteMovies -> getFavoriteMovies()
            }
        }
    }

    private suspend fun getFavoriteMovies() {
        setState(FavoriteMoviesContract.State.Loading)
        try {
            val movies = repository.getFavoriteMovies()
            setState(FavoriteMoviesContract.State.Success(movies))
        } catch (e: Exception) {
            setState(FavoriteMoviesContract.State.Error(e))
        }
    }
}

object FavoriteMoviesContract {
    sealed interface State : StateUi {
        object Loading : State
        data class Success(val movies: List<PopularMovieDetail>) : State
        data class Error(val error: Throwable) : State
    }

    sealed interface Event : EventUi {
        object GetFavoriteMovies : Event
    }

    sealed interface Effect : EffectUi
}