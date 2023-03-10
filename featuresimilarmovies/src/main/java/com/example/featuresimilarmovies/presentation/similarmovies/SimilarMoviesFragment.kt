package com.example.featuresimilarmovies.presentation.similarmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coreui.fragment.BaseFragmentViewBinding
import com.example.featuresimilarmovies.R
import com.example.featuresimilarmovies.databinding.FragmentSimilarMoviesBinding

class SimilarMoviesFragment :
    BaseFragmentViewBinding<FragmentSimilarMoviesBinding>(R.layout.fragment_similar_movies) {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ): FragmentSimilarMoviesBinding {
        return FragmentSimilarMoviesBinding.inflate(inflater, container, attachToParent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = activity?.intent?.getIntExtra("movieId", DEFAULT_MOVIE_ID)
    }

    private companion object {
        const val DEFAULT_MOVIE_ID = -1
    }
}