package com.example.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.remote.datasource.PopularMoviesRemoteDataSource
import com.example.data.remote.models.MovieResponse
import com.example.data.remote.utils.Result

private const val STARTING_PAGE_INDEX = 1

class PopularMoviePagingSource(
    private val remoteDataSource: PopularMoviesRemoteDataSource
) : PagingSource<Int, MovieResponse>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResponse> {
        val pageIndex = params.key ?: STARTING_PAGE_INDEX
        return when (val result = remoteDataSource.getPopularMovies(pageIndex)) {
            is Result.Success -> {
                val movies = result.data.movieList.orEmpty()
                val nextKey = if (movies.isEmpty()) {
                    null
                } else {
                    pageIndex + 1
                }
                LoadResult.Page(
                    data = movies,
                    prevKey = if (pageIndex == STARTING_PAGE_INDEX) null else pageIndex - 1,
                    nextKey = nextKey
                )
            }
            is Result.Error -> {
                LoadResult.Error(result.error)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}