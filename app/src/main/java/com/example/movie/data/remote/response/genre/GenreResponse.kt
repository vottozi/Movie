package com.example.movie.data.remote.response.genre

import com.google.gson.annotations.SerializedName
import com.example.movie.data.remote.response.genre.GenreDto

data class GenreResponse(
    @SerializedName("genres")
    val genres: List<GenreDto>?
)