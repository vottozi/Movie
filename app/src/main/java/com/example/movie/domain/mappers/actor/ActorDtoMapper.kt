package com.example.movie.domain.mappers.actor

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.actor.ActorDto
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Actor
import javax.inject.Inject

class ActorDtoMapper @Inject constructor() : Mapper<ActorDto, Actor> {
    override fun map(input: ActorDto): Actor {
        return Actor(
            actorID = input.id ?: 0,
            actorName = input.name ?: "unknown",
            actorImage = BuildConfig.IMAGE_BASE_PATH + input.profilePath
        )
    }
}