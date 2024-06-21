package com.example.movie.domain.usecases.movieDetails

import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.movie.RatingStatusMoviesMapper
import com.example.movie.domain.models.RatingStatus
import javax.inject.Inject

class SetRatingUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val ratingStatusMoviesMapper: RatingStatusMoviesMapper
) {

    suspend operator fun invoke(movieId: Int, value: Float): RatingStatus {
        val response = if (value == 0f) {
            movieRepository.deleteRating(movieId)
        } else {
            movieRepository.setRating(movieId, value)
        }
        return response?.let {
            ratingStatusMoviesMapper.map(response)
        }?: throw Throwable("Not Success")
    }
}