package com.example.movie.ui.mappers

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Actor
import com.example.movie.ui.models.ActorUiState
import javax.inject.Inject

class ActorUiMapper @Inject constructor() : Mapper<Actor, ActorUiState> {
    override fun map(input: Actor): ActorUiState {
        return ActorUiState(
            input.actorID,
            input.actorName,
            input.actorImage,
        )
    }
}