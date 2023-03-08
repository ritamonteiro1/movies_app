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

class PopularMoviesViewModel(
    private val repository: PopularMoviesRepository,
) : BaseViewModel<PopularMoviesContract.Event, PopularMoviesContract.State, PopularMoviesContract.Effect>() {

    override fun createInitialState(): PopularMoviesContract.State {
        return PopularMoviesContract.State.Initial
    }

    override fun handleEvent(event: PopularMoviesContract.Event) {
        when (event) {
            is PopularMoviesContract.Event.GetPopularMovies -> {
                val popularMoviesFlow = getPopularMovies()
                setState(PopularMoviesContract.State.Success(popularMoviesFlow))
            }
        }
    }

    private fun getPopularMovies(): Flow<PagingData<PopularMovie>> {
        return repository.getPopularMovies().cachedIn(viewModelScope)
    }

}

object PopularMoviesContract {
    sealed interface Event : EventUi {
        object GetPopularMovies : Event
    }

    sealed interface Effect : EffectUi

    sealed interface State : StateUi {
        object Initial : State
        data class Success(val popularMovies: Flow<PagingData<PopularMovie>>) : State
    }
}