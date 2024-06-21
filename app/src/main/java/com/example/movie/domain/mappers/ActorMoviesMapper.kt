package com.example.movie.domain.mappers

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.MovieDto
import com.example.movie.domain.models.ActorMovie
import javax.inject.Inject

class ActorMoviesMapper @Inject constructor() : Mapper<MovieDto, ActorMovie>{
    override fun map(input: MovieDto): ActorMovie {
        return ActorMovie(
            input.id ?: 0,
            (BuildConfig.IMAGE_BASE_PATH + input.posterPath),
        )
    }
}