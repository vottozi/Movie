package com.example.movie.domain.mappers.movie

import com.example.movie.data.local.database.entity.movie.PopularMovieEntity
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.PopularMovie
import javax.inject.Inject

class PopularMovieMapper @Inject constructor() : Mapper<PopularMovieEntity, PopularMovie> {
    override fun map(input: PopularMovieEntity): PopularMovie {
        return PopularMovie(
            movieID = input.id,
            title = input.title,
            imageUrl = input.imageUrl,
            movieRate = input.movieRate,
            genre = input.genre,
        )
    }
}