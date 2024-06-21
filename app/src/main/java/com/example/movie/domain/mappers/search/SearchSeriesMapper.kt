package com.example.movie.domain.mappers.search

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.TVShowsDTO
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import com.example.movie.utilities.Constants
import javax.inject.Inject

class SearchSeriesMapper @Inject constructor() : Mapper<TVShowsDTO, Media> {
    override fun map(input: TVShowsDTO): Media {
        return Media(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.backdropPath,
            Constants.TV_SHOWS,
            input.originalName ?: "",
            input.firstAirDate?.substringBefore('-') ?: "",
            input.voteAverage?.toFloat() ?: 0F,
        )
    }
}