package com.example.movie.domain.usecases.tvShowDetails

import com.example.movie.data.repository.SeriesRepository
import com.example.movie.domain.mappers.series.RatingStatusTvShowMapper
import com.example.movie.domain.models.RatingStatus
import javax.inject.Inject

class SetRatingUesCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val ratingStatusTvShowMapper: RatingStatusTvShowMapper
) {
    suspend operator fun invoke(tvShowId: Int, rating: Float): RatingStatus {
        val response = if (rating == 0f) {
            seriesRepository.deleteTvShowRating(tvShowId)
        } else {
            seriesRepository.setRating(tvShowId, rating)
        }
        return response?.let {
            ratingStatusTvShowMapper.map(response)
        }?: throw Throwable("Not Success")
    }
}
