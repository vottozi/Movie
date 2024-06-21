package com.example.movie.domain.mappers.movie


import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.MovieDto
import com.example.movie.domain.enums.MediaType
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import com.example.movie.utilities.Constants
import javax.inject.Inject

class MovieMapper @Inject constructor() : Mapper<MovieDto, Media> {
    override fun map(input: MovieDto): Media {
        return Media(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.posterPath,
            MediaType.MOVIE.value,
            input.originalTitle ?: "",
            input.releaseDate?.substringBefore('-') ?: "",
            input.voteAverage?.toFloat() ?: 0f
        )
    }
}