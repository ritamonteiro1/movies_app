package com.example.featuresimilarmovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.utils.Result
import com.example.featuresimilarmovies.domain.models.SimilarMovieList
import com.example.featuresimilarmovies.domain.repository.SimilarMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SimilarMoviesViewModel(
    private val repository: SimilarMoviesRepository,
    private val dispatcher: CoroutineContext = Dispatchers.Main
) : ViewModel() {

    private val _state =
        MutableStateFlow<SimilarMoviesContract.State>(SimilarMoviesContract.State.Loading)
    val state: StateFlow<SimilarMoviesContract.State> = _state

    fun getSimilarMovies(movieId: Int) {
        viewModelScope.launch(dispatcher) {
            viewModelScope.launch(dispatcher) {
                when (val result = repository.getSimilarMovies(movieId)) {
                    is Result.Success -> {
                        _state.value = SimilarMoviesContract.State.Success(result.data)
                    }
                    is Result.Error -> {
                        _state.value = SimilarMoviesContract.State.Error(result.error)
                    }
                }
            }
        }
    }
}

object SimilarMoviesContract {
    sealed interface State {
        object Loading : State
        data class Success(val movies: SimilarMovieList) : State
        data class Error(val error: Throwable) : State
    }
}