package com.example.movie.data.remote.response

import com.google.gson.annotations.SerializedName
import com.example.movie.data.remote.response.actor.ActorDto

data class CreditsDto(
    @SerializedName("cast")
    val cast: List<ActorDto>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0
)