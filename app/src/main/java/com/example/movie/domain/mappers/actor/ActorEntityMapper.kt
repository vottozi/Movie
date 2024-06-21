package com.example.movie.domain.mappers.actor

import com.example.movie.BuildConfig
import com.example.movie.data.local.database.entity.ActorEntity
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Actor
import javax.inject.Inject

class ActorEntityMapper @Inject constructor() : Mapper<ActorEntity, Actor> {
    override fun map(input: ActorEntity): Actor {
        return Actor(
            actorID = input.id,
            actorName = input.name,
            actorImage = BuildConfig.IMAGE_BASE_PATH + input.imageUrl
        )
    }
}