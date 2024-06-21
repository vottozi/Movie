package com.example.movie.domain.mappers.series

import android.media.Rating
import com.example.movie.data.remote.response.movie.RatingDto
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.RatingStatus
import com.example.movie.ui.tvShowDetails.tvShowUIState.RatingUIState
import javax.inject.Inject

class RatingStatusTvShowMapper @Inject constructor(): Mapper<RatingDto, RatingStatus> {
    override fun map(input: RatingDto): RatingStatus {
        return RatingStatus(
            statusCode = input.statusCode ?: 0,
            statusMessage = input.statusMessage ?: "",
        )
    }
}