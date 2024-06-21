package com.example.movie.domain.mappers.search

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.actor.ActorDto
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import com.example.movie.utilities.Constants
import javax.inject.Inject

class SearchActorMapper @Inject constructor() : Mapper<ActorDto, Media> {
    override fun map(input: ActorDto): Media {
        return Media(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.profilePath,
            Constants.ACTOR,
            input.name ?: "",
            "",
            0F
        )
    }
}
