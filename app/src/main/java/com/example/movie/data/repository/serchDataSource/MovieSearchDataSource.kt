package com.example.movie.data.repository.serchDataSource

import com.example.movie.data.remote.response.MovieDto
import com.example.movie.data.remote.service.MovieService
import com.example.movie.data.repository.BasePagingSource
import javax.inject.Inject
import kotlin.properties.Delegates

class MovieSearchDataSource @Inject constructor(private val service: MovieService) :
    BasePagingSource<MovieDto>() {
    private var movieSearchText by Delegates.notNull<String>()

    fun setSearchText(searchText: String) {
        movieSearchText = searchText
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
        val pageNumber = params.key ?: 1
        return try {
            val response = service.searchForMovie(movieSearchText, pageNumber)
            val pagedResponse = response.body()
            LoadResult.Page(
                data = pagedResponse?.items ?: emptyList(),
                prevKey = null,
                nextKey = if (pagedResponse?.items?.isEmpty() == true) null else pagedResponse?.page?.plus(
                    1
                )
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }
}