package com.example.movie.domain.mappers.series

import com.example.movie.BuildConfig
import com.example.movie.data.local.database.entity.series.TopRatedSeriesEntity
import com.example.movie.domain.enums.MediaType
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import javax.inject.Inject

class TopRatedSeriesMapper @Inject constructor() : Mapper<TopRatedSeriesEntity, Media> {
    override fun map(input: TopRatedSeriesEntity): Media {
        return Media(
            mediaID = input.id,
            mediaName = input.name,
            mediaImage = BuildConfig.IMAGE_BASE_PATH + input.imageUrl,
            mediaRate = 0f,
            mediaDate = "",
            mediaType = MediaType.TV_SHOW.value,
        )
    }
}