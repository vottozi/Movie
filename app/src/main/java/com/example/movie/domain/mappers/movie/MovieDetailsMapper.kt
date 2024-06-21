package com.example.movie.domain.mappers.movie

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.movie.MovieDetailsDto
import com.example.movie.domain.enums.MediaType
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.MovieDetails
import com.example.movie.utilities.convertToDayMonthYearFormat
import javax.inject.Inject

class MovieDetailsMapper @Inject constructor() : Mapper<MovieDetailsDto, MovieDetails> {
    override fun map(input: MovieDetailsDto): MovieDetails {
        return MovieDetails(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.backdropPath,
            input.title ?: "",
            input.releaseDate?.convertToDayMonthYearFormat() ?: "",
            input.genres?.map { it?.name }?.joinToString(" , ") ?: "",
            input.runtime ?: 0,
            input.voteCount ?: 0,
            input.voteAverage.toString().take(3),
            input.overview ?: "",
        )
    }
}