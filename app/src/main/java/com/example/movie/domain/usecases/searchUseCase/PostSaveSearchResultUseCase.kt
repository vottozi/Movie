package com.example.movie.domain.usecases.searchUseCase

import com.example.movie.data.local.database.entity.SearchHistoryEntity
import com.example.movie.data.repository.MovieRepository
import javax.inject.Inject


class PostSaveSearchResultUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(id: Int, name: String) {
        movieRepository.insertSearchItem(
            SearchHistoryEntity(
                id = id.toLong(),
                search = name
            )
        )
    }
}