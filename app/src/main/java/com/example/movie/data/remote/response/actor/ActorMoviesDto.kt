package com.example.movie.data.remote.response.actor

import com.google.gson.annotations.SerializedName
import com.example.movie.data.remote.response.MovieDto

data class ActorMoviesDto(
    @SerializedName("cast")
    val cast: List<MovieDto>? = null,
    @SerializedName("id")
    val id: Int? = null
)