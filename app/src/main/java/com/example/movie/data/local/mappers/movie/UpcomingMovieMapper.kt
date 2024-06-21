package com.example.movie.data.local.mappers.movie

import com.example.movie.data.local.database.entity.movie.UpcomingMovieEntity
import com.example.movie.data.remote.response.MovieDto
import com.example.movie.domain.mappers.Mapper
import javax.inject.Inject

class UpcomingMovieMapper @Inject constructor() : Mapper<MovieDto, UpcomingMovieEntity> {
    override fun map(input: MovieDto): UpcomingMovieEntity {
        return UpcomingMovieEntity(
            id = input.id ?: 0,
            name = input.originalTitle ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}