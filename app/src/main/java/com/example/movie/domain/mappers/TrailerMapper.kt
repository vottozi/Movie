package com.example.movie.domain.mappers

import com.example.movie.data.remote.response.trailerVideosDto.TrailerDto
import com.example.movie.domain.models.Trailer
import com.example.movie.utilities.getKey
import javax.inject.Inject

class TrailerMapper @Inject constructor() : Mapper<TrailerDto, Trailer> {
    override fun map(input: TrailerDto): Trailer {
        return Trailer(input.results?.getKey() ?: "")
    }
}