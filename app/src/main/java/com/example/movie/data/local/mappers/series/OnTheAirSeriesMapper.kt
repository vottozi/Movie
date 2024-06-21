package com.example.movie.data.local.mappers.series

import com.example.movie.data.local.database.entity.series.OnTheAirSeriesEntity
import com.example.movie.data.remote.response.TVShowsDTO
import com.example.movie.domain.mappers.Mapper
import javax.inject.Inject

class OnTheAirSeriesMapper  @Inject constructor() : Mapper<TVShowsDTO, OnTheAirSeriesEntity> {
    override fun map(input: TVShowsDTO): OnTheAirSeriesEntity {
        return OnTheAirSeriesEntity(
            id = input.id ?:0,
            name = input.originalName?:"",
            imageUrl = input.posterPath ?:""
        )
    }
}