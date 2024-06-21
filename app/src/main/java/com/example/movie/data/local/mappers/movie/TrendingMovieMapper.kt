package com.example.movie.data.local.mappers.movie

import com.example.movie.data.local.database.entity.movie.TrendingMovieEntity
import com.example.movie.data.remote.response.MovieDto
import com.example.movie.domain.mappers.Mapper
import javax.inject.Inject

class TrendingMovieMapper @Inject constructor() : Mapper<MovieDto, TrendingMovieEntity> {
    override fun map(input: MovieDto): TrendingMovieEntity {
        return TrendingMovieEntity(
            id = input.id ?:0,
            name = input.originalTitle?:"",
            imageUrl = input.posterPath ?:""
        )
    }
}