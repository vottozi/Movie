package com.example.movie.data.local.mappers.movie

import com.example.movie.data.local.database.entity.movie.NowStreamingMovieEntity
import com.example.movie.data.remote.response.MovieDto
import com.example.movie.domain.mappers.Mapper
import javax.inject.Inject

class NowStreamingMovieMapper @Inject constructor() : Mapper<MovieDto, NowStreamingMovieEntity> {
    override fun map(input: MovieDto): NowStreamingMovieEntity {
        return NowStreamingMovieEntity(
            id = input.id ?: 0,
            name = input.originalTitle ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}