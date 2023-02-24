package com.example.featurepopularmovies.presentation.popularmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.featurepopularmovies.domain.models.PopularMovie
import com.example.featurepopularmovies.domain.repository.PopularMoviesRepository
import kotlinx.coroutines.flow.Flow

class PopularMoviesViewModel(
    private val repository: PopularMoviesRepository,
) : ViewModel() {

    fun getPopularMovies(): Flow<PagingData<PopularMovie>> {
        return repository.getPopularMovies().cachedIn(viewModelScope)
    }
}

object PopularMoviesContract {
    sealed interface Events {
        object GetPopularMovies : Events
    }

    sealed interface Effects {
        object ShowPopularMovies : Effects
    }
}