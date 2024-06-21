package com.example.movie.domain.mappers.actor

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.actor.ActorDto
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.ActorDetails
import javax.inject.Inject

class ActorDetailsMapper @Inject constructor() : Mapper<ActorDto, ActorDetails> {
    override fun map(input: ActorDto): ActorDetails {

        val gender = if (input.gender == 1) {
            "Female"
        } else {
            "Male"
        }

        return ActorDetails(
            input.id ?: 0,
            input.name ?: "",
            BuildConfig.IMAGE_BASE_PATH + input.profilePath,
            input.birthday ?: "",
            input.placeOfBirth ?: "unknown",
            input.biography ?: "",
            input.knownForDepartment ?: "-",
            gender,
        )
    }
}