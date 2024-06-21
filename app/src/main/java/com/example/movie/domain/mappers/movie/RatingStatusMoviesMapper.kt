package com.example.movie.domain.mappers.movie

import com.example.movie.data.remote.response.movie.RatingDto
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.RatingStatus
import javax.inject.Inject

class RatingStatusMoviesMapper @Inject constructor() : Mapper<RatingDto, RatingStatus> {
    override fun map(input: RatingDto): RatingStatus {
        return RatingStatus(
            statusCode = input.statusCode ?: 0,
            statusMessage = input.statusMessage ?: "",
        )
    }
}