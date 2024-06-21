package com.example.movie.domain.usecases.home.getData.movie

import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.movie.AdventureMovieMapper
import com.example.movie.domain.models.Media
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAdventureMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: AdventureMovieMapper,
) {

    suspend operator fun invoke(): Flow<List<Media>> {
        return movieRepository.getAdventureMovies().map {
            it.map(movieMapper::map)
        }
    }
}