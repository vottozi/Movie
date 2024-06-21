package com.example.movie.domain.mappers

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.DailyTrendingDto
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import com.example.movie.utilities.Constants
import javax.inject.Inject

class ItemListMapper @Inject constructor() : Mapper<DailyTrendingDto, Media> {
    override fun map(input: DailyTrendingDto): Media {
        return Media(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.posterPath,
            mediaType = input.mediaType ?: Constants.MOVIE,
            input.originalLanguage ?: input.originalTitle ?: "",
            input.releaseDate?.substringBefore('-') ?: "",
            input.voteAverage?.toFloat() ?: 0F,
        )
    }
}