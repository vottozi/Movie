package com.example.movie.ui.movieDetails.mapper

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Actor
import com.example.movie.ui.models.ActorUiState
import javax.inject.Inject

class ActorUIStateMapper @Inject constructor() : Mapper<Actor, ActorUiState> {
    override fun map(input: Actor): ActorUiState {
        return ActorUiState(
            id = input.actorID,
            imageUrl = input.actorImage,
            name = input.actorName
        )
    }
}