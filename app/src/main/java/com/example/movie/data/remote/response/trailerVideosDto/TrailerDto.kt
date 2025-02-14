package com.example.movie.data.remote.response.trailerVideosDto

import com.google.gson.annotations.SerializedName

data class TrailerDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("results")
    val results: List<ResultDto?>? = null
)