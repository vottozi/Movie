package com.example.movie.domain.mappers.movie

import com.example.movie.BuildConfig
import com.example.movie.data.local.database.entity.movie.TrendingMovieEntity
import com.example.movie.domain.enums.MediaType
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import javax.inject.Inject

class TrendingMovieMapper @Inject constructor() : Mapper<TrendingMovieEntity, Media> {
    override fun map(input: TrendingMovieEntity): Media {
        return Media(
            mediaID = input.id,
            mediaName = input.name,
            mediaImage = BuildConfig.IMAGE_BASE_PATH + input.imageUrl,
            mediaRate = 0f,
            mediaDate = "",
            mediaType = MediaType.MOVIE.value,
        )
    }
}