package com.example.movie.data.local.mappers

import com.example.movie.data.local.database.entity.ActorEntity
import com.example.movie.data.remote.response.actor.ActorDto
import com.example.movie.domain.mappers.Mapper
import java.util.*
import javax.inject.Inject

class ActorMapper @Inject constructor(): Mapper<ActorDto, ActorEntity> {
    override fun map(input: ActorDto): ActorEntity {
        return ActorEntity(
            id = input.id?:0,
            name = input.name?:"",
            imageUrl = input.profilePath?:"",
        )
    }
}