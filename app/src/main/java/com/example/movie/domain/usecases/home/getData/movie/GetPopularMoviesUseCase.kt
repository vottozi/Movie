package com.example.movie.domain.usecases.home.getData.movie

import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.movie.PopularMovieMapper
import com.example.movie.domain.models.PopularMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: PopularMovieMapper,
) {
    suspend  operator fun invoke(): Flow<List<PopularMovie>> {
        return movieRepository.getPopularMovies().map { items ->
            items.map(movieMapper::map)
        }
    }
}