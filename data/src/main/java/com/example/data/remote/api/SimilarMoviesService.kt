package com.example.data.remote.api

import com.example.data.remote.models.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SimilarMoviesService {

    @GET("movie/{movie_id}/recommendations")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int
    ): MovieListResponse
}