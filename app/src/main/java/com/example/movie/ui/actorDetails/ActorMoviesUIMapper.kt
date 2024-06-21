package com.example.movie.ui.actorDetails

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.ActorMovie
import javax.inject.Inject

class ActorMoviesUIMapper @Inject constructor() : Mapper<ActorMovie, ActorMoviesUIState> {
    override fun map(input: ActorMovie): ActorMoviesUIState {
        return ActorMoviesUIState(
            id = input.movieId,
            imageUrl = input.movieImage
        )
    }
}