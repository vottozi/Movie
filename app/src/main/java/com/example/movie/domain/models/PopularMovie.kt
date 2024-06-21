package com.example.movie.domain.models

data class PopularMovie(
    val movieID: Int,
    val title: String,
    val imageUrl: String,
    val movieRate:Double,
    val genre: List<String>
)
