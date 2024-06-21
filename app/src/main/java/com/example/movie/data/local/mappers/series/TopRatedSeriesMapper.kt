package com.example.movie.data.local.mappers.series

import com.example.movie.data.local.database.entity.series.TopRatedSeriesEntity
import com.example.movie.data.remote.response.TVShowsDTO
import com.example.movie.domain.mappers.Mapper
import javax.inject.Inject

class TopRatedSeriesMapper @Inject constructor() : Mapper<TVShowsDTO, TopRatedSeriesEntity> {
    override fun map(input: TVShowsDTO): TopRatedSeriesEntity {
        return TopRatedSeriesEntity(
            id = input.id ?:0,
            name = input.originalName?:"",
            imageUrl = input.posterPath ?:""
        )
    }
}