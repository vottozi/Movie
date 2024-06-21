package com.example.movie.domain.usecases

import com.example.movie.data.repository.MovieRepository
import com.example.movie.data.repository.SeriesRepository
import com.example.movie.domain.enums.MediaType
import com.example.movie.domain.mappers.ReviewMapper
import com.example.movie.domain.models.Review
import javax.inject.Inject

class GetReviewsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val seriesRepository: SeriesRepository,
    private val reviewMapper: ReviewMapper,
) {

    suspend operator fun invoke(type: MediaType, mediaID: Int): List<Review> {
        val reviews = when (type) {
            MediaType.MOVIE -> movieRepository.getMovieReviews(mediaID)
            MediaType.TV_SHOW -> seriesRepository.getTvShowReviews(mediaID)
        }
        return reviews?.let {
            it.map { reviewMapper.map(it) }
        } ?: throw Throwable("Not Success")
    }

}