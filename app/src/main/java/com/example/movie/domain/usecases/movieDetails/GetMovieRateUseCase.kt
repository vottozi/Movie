package com.example.movie.domain.usecases.movieDetails

import com.example.movie.data.repository.MovieRepository
import javax.inject.Inject

class GetMovieRateUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {

    suspend operator fun invoke(movieID: Int): Float {
        val result = movieRepository.getRatedMovie()
        return result?.let {
            it.find { it.id == movieID }?.rating ?: 0F
        } ?: throw Throwable("Error")
    }
}