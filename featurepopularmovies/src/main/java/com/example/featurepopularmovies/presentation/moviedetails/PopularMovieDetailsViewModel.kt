package com.example.featurepopularmovies.presentation.moviedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featurepopularmovies.domain.models.PopularMovieDetail
import com.example.featurepopularmovies.domain.repository.PopularMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import com.example.core.utils.Result
import kotlinx.coroutines.flow.*

class PopularMovieDetailsViewModel(
    private val repository: PopularMoviesRepository,
    private val dispatcher: CoroutineContext = Dispatchers.Main
) : ViewModel() {
    private val _state =
        MutableStateFlow<PopularMovieDetailsContract.State>(PopularMovieDetailsContract.State.Loading)
    val state: StateFlow<PopularMovieDetailsContract.State> = _state

    private val _effect =
        MutableSharedFlow<PopularMovieDetailsContract.Effect>()
    val effect: SharedFlow<PopularMovieDetailsContract.Effect> = _effect

    private val _event = MutableSharedFlow<PopularMovieDetailsContract.Event>()
    val collect = _event.onEach { event ->
        when (event) {
            is PopularMovieDetailsContract.Event.GetMovieDetails -> {
                getMovieDetails(event.movieId)
            }
            is PopularMovieDetailsContract.Event.DeleteFavoriteMovie -> {
                deleteFavoriteMovie(event.movieId)
            }
            is PopularMovieDetailsContract.Event.SaveFavoriteMovie -> {
                saveFavoriteMovie(event.movie)
            }
        }
    }

    private suspend fun setEffect(effect: PopularMovieDetailsContract.Effect) {
        _effect.emit(effect)
    }

    suspend fun processEvent(event: PopularMovieDetailsContract.Event) {
        _event.emit(event)
    }

    private fun setState(state: PopularMovieDetailsContract.State) {
        _state.value = state
    }

    private suspend fun getMovieDetails(movieId: Int) {
        setState(PopularMovieDetailsContract.State.Loading)
        viewModelScope.launch(dispatcher) {
            when (val result = repository.getPopularMovieDetails(movieId)) {
                is Result.Success -> {
                    setState(PopularMovieDetailsContract.State.Success(result.data))
                }
                is Result.Error -> {
                    setState(PopularMovieDetailsContract.State.Error(result.error))
                }
            }
        }
    }

    private suspend fun saveFavoriteMovie(movie: PopularMovieDetail) {
        viewModelScope.launch(dispatcher) {
            repository.saveFavoriteMovie(movie)
            setEffect(PopularMovieDetailsContract.Effect.SaveFavoriteMovie)
        }
    }

    private suspend fun deleteFavoriteMovie(movieId: Int) {
        viewModelScope.launch(dispatcher) {
            repository.deleteFavoriteMovie(movieId)
            setEffect(PopularMovieDetailsContract.Effect.DeleteFavoriteMovie)
        }
    }
}

object PopularMovieDetailsContract {
    sealed interface Event {
        data class GetMovieDetails(val movieId: Int) : Event
        data class SaveFavoriteMovie(val movie: PopularMovieDetail) : Event
        data class DeleteFavoriteMovie(val movieId: Int) : Event
    }

    sealed interface Effect {
        object DeleteFavoriteMovie : Effect
        object SaveFavoriteMovie : Effect
    }

    sealed interface State {
        object Loading : State
        data class Success(val movie: PopularMovieDetail) : State
        data class Error(val error: Throwable) : State
    }
}