package com.example.movie.domain.usecases

import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.*
import com.example.movie.domain.models.Media
import javax.inject.Inject


class GetTrendingMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMappersContainer: MovieMappersContainer,
) {
    suspend operator fun invoke(): List<Media> {
        return  ListMapper(movieMappersContainer.itemListMapper)
            .mapList(movieRepository.getDailyTrending().items)
    }
}
