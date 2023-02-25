package com.example.featuresimilarmovies.presentation.similarmovies

import androidx.lifecycle.viewModelScope
import com.example.core.utils.Result
import com.example.coreui.viewmodel.BaseViewModel
import com.example.coreui.viewmodel.EffectUi
import com.example.coreui.viewmodel.EventUi
import com.example.coreui.viewmodel.StateUi
import com.example.featuresimilarmovies.domain.models.SimilarMovieList
import com.example.featuresimilarmovies.domain.repository.SimilarMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SimilarMoviesViewModel(
    private val repository: SimilarMoviesRepository,
    private val dispatcher: CoroutineContext = Dispatchers.Main
) : BaseViewModel<SimilarMoviesContract.Event, SimilarMoviesContract.State, SimilarMoviesContract.Effect>() {
    override fun createInitialState(): SimilarMoviesContract.State {
        return SimilarMoviesContract.State.Loading
    }

    override fun handleEvent(event: SimilarMoviesContract.Event) {
        when (event) {
            is SimilarMoviesContract.Event.GetSimilarMovies -> getSimilarMovies(event.movieId)
        }
    }

    private fun getSimilarMovies(movieId: Int) {
        setState(SimilarMoviesContract.State.Loading)
        viewModelScope.launch(dispatcher) {
            when (val result = repository.getSimilarMovies(movieId)) {
                is Result.Success -> {
                    setState(SimilarMoviesContract.State.Success(result.data))
                }
                is Result.Error -> {
                    setState(SimilarMoviesContract.State.Error(result.error))
                }
            }
        }
    }
}

object SimilarMoviesContract {
    sealed interface State : StateUi {
        object Loading : State
        data class Success(val movies: SimilarMovieList) : State
        data class Error(val error: Throwable) : State
    }

    sealed interface Event : EventUi {
        data class GetSimilarMovies(val movieId: Int) : Event
    }

    sealed interface Effect : EffectUi
}