package com.example.movie.domain.usecases.searchUseCase

import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.search.SearchHistoryMapper
import com.example.movie.domain.models.SearchHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetSearchHistoryUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val searchHistoryMapper: SearchHistoryMapper
) {
    suspend operator fun invoke(): Flow<List<SearchHistory>> {
        return movieRepository.getAllSearchHistory().map { response ->
            response.map { searchHistoryMapper.map(it) }
        }
    }
}