package com.example.movie.data.local.mappers.movie

import com.example.movie.data.local.database.entity.movie.AdventureMovieEntity

import com.example.movie.data.remote.response.MovieDto
import com.example.movie.domain.mappers.Mapper
import javax.inject.Inject

class AdventureMovieMapper @Inject constructor() : Mapper<MovieDto, AdventureMovieEntity> {
    override fun map(input: MovieDto): AdventureMovieEntity {
        return AdventureMovieEntity(
            id = input.id ?: 0,
            name = input.originalTitle ?: "",
            imageUrl = input.posterPath ?: ""
        )
    }
}