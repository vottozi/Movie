package com.example.movie.domain.mappers

import com.example.movie.data.remote.response.genre.GenreDto
import com.example.movie.domain.models.Genre
import javax.inject.Inject

class GenreMapper @Inject constructor() : Mapper<GenreDto, Genre> {
    override fun map(input: GenreDto): Genre {
        return Genre(
            input.id ?: 0,
            input.name ?: "unknown"
        )
    }
}