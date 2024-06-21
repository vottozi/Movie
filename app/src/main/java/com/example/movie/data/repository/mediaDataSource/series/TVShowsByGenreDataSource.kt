package com.example.movie.data.repository.mediaDataSource.series

import com.example.movie.data.remote.response.TVShowsDTO
import com.example.movie.data.remote.service.MovieService
import com.example.movie.data.repository.mediaDataSource.BasePagingSource
import javax.inject.Inject
import kotlin.properties.Delegates

class TVShowsByGenreDataSource @Inject constructor(private val service: MovieService) :
    BasePagingSource<TVShowsDTO>() {

    private var mediaGenreID by Delegates.notNull<Int>()

    fun setGenre(genreID: Int) {
        mediaGenreID = genreID
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TVShowsDTO> {
        val pageNumber = params.key ?: 1

        return try {
            val response = service.getTvListByGenre(mediaGenreID, pageNumber)

            LoadResult.Page(
                data = response.body()?.items as List<TVShowsDTO>,
                prevKey = null,
                nextKey = response.body()?.page?.plus(1)
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }
}