package com.example.movie.domain.usecases.searchUseCase

import androidx.paging.*
import com.example.movie.data.repository.SeriesRepository
import com.example.movie.domain.mappers.search.SearchSeriesMapper
import com.example.movie.domain.models.Media
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetSearchForSeriesUserCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val seriesMapper: SearchSeriesMapper
) {

    suspend operator fun invoke(searchTerm: String): Flow<PagingData<Media>> {
        return wrapper({seriesRepository.searchForSeriesPager(searchTerm)}, seriesMapper::map)
    }

    private suspend fun <T : Any> wrapper(
        data: suspend () -> Pager<Int, T>,
        mapper: (T) -> Media,
    ): Flow<PagingData<Media>> {
        return data().flow.map { pager -> pager.map { mapper(it) } }
    }

}