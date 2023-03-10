package com.example.featurepopularmovies.presentation.moviedetails

import androidx.lifecycle.viewModelScope
import com.example.core.utils.Result
import com.example.coreui.viewmodel.BaseViewModel
import com.example.coreui.viewmodel.EffectUi
import com.example.coreui.viewmodel.EventUi
import com.example.coreui.viewmodel.StateUi
import com.example.featurepopularmovies.domain.models.PopularMovieDetail
import com.example.featurepopularmovies.domain.repository.PopularMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PopularMovieDetailsViewModel(
    private val repository: PopularMoviesRepository,
    private val dispatcher: CoroutineContext = Dispatchers.Main
) : BaseViewModel<PopularMovieDetailsContract.Event, PopularMovieDetailsContract.State, PopularMovieDetailsContract.Effect>() {
    override fun createInitialState(): PopularMovieDetailsContract.State {
        return PopularMovieDetailsContract.State.Loading
    }

    override fun handleEvent(event: PopularMovieDetailsContract.Event) {
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

    private fun getMovieDetails(movieId: Int) {
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

    private fun saveFavoriteMovie(movie: PopularMovieDetail) {
        viewModelScope.launch(dispatcher) {
            repository.saveFavoriteMovie(movie)
            setEffect(PopularMovieDetailsContract.Effect.FavoriteMovieSaved)
        }
    }

    private fun deleteFavoriteMovie(movieId: Int) {
        viewModelScope.launch(dispatcher) {
            repository.deleteFavoriteMovie(movieId)
            setEffect(PopularMovieDetailsContract.Effect.FavoriteMovieDeleted)
        }
    }
}

object PopularMovieDetailsContract {
    sealed interface Event : EventUi {
        data class GetMovieDetails(val movieId: Int) : Event
        data class SaveFavoriteMovie(val movie: PopularMovieDetail) : Event
        data class DeleteFavoriteMovie(val movieId: Int) : Event
    }

    sealed interface Effect : EffectUi {
        object FavoriteMovieSaved : Effect
        object FavoriteMovieDeleted : Effect
    }

    sealed interface State : StateUi {
        object Loading : State
        data class Success(val movie: PopularMovieDetail) : State
        data class Error(val error: Throwable) : State
    }
}