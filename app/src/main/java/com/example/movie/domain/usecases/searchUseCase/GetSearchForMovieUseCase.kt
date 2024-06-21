package com.example.movie.domain.usecases.searchUseCase

import androidx.paging.*
import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.movie.MovieMapper
import com.example.movie.domain.models.Media
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetSearchForMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) {

    suspend operator fun invoke(searchTerm: String):Flow<PagingData<Media>>{
        return wrapper({movieRepository.searchForMoviePager(searchTerm)}, movieMapper::map)
    }

    private suspend fun <T : Any> wrapper(
        data: suspend () -> Pager<Int, T>,
        mapper: (T) -> Media,
    ): Flow<PagingData<Media>> {
        return data().flow.map { pager -> pager.map { mapper(it) } }
    }

}