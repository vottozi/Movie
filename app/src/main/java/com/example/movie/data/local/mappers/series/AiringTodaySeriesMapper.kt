package com.example.movie.data.local.mappers.series

import com.example.movie.data.local.database.entity.series.AiringTodaySeriesEntity
import com.example.movie.data.remote.response.TVShowsDTO
import com.example.movie.domain.mappers.Mapper
import javax.inject.Inject

class AiringTodaySeriesMapper @Inject constructor() : Mapper<TVShowsDTO, AiringTodaySeriesEntity> {
    override fun map(input: TVShowsDTO): AiringTodaySeriesEntity {
        return AiringTodaySeriesEntity(
            id = input.id ?: 0,
            name = input.originalName ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}