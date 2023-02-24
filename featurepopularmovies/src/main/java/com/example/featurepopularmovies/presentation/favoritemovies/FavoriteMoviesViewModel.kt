package com.example.featurepopularmovies.presentation.favoritemovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featurepopularmovies.domain.models.PopularMovieDetail
import com.example.featurepopularmovies.domain.repository.PopularMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class FavoriteMoviesViewModel(
    private val repository: PopularMoviesRepository,
    private val dispatcher: CoroutineContext = Dispatchers.Main
) : ViewModel() {
    private val _state =
        MutableStateFlow<FavoriteMoviesContract.State>(FavoriteMoviesContract.State.Loading)
    val state: StateFlow<FavoriteMoviesContract.State> = _state

    suspend fun getFavoriteMovies() {
        _state.value = FavoriteMoviesContract.State.Loading
        viewModelScope.launch(dispatcher) {
            repository.getFavoriteMovies().let { movies ->
                _state.value = FavoriteMoviesContract.State.Success(movies)
            }
        }
    }
}

object FavoriteMoviesContract {

    sealed interface State {
        object Loading : State
        data class Success(val movies: List<PopularMovieDetail>) : State
        data class Error(val error: Throwable) : State
    }
}