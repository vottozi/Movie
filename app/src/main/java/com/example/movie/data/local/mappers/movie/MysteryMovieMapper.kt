package com.example.movie.data.local.mappers.movie

import com.example.movie.data.local.database.entity.movie.MysteryMovieEntity
import com.example.movie.data.remote.response.MovieDto
import com.example.movie.domain.mappers.Mapper
import javax.inject.Inject

class MysteryMovieMapper @Inject constructor() : Mapper<MovieDto, MysteryMovieEntity> {
    override fun map(input: MovieDto): MysteryMovieEntity {
        return MysteryMovieEntity(
            id = input.id ?: 0,
            name = input.originalTitle ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}