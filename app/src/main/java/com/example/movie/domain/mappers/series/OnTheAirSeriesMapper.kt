package com.example.movie.domain.mappers.series

import com.example.movie.BuildConfig
import com.example.movie.data.local.database.entity.series.OnTheAirSeriesEntity
import com.example.movie.domain.enums.MediaType
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import javax.inject.Inject

class OnTheAirSeriesMapper @Inject constructor() : Mapper<OnTheAirSeriesEntity, Media> {
    override fun map(input: OnTheAirSeriesEntity): Media {
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