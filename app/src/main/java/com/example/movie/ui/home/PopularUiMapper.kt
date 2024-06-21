package com.example.movie.ui.home

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.PopularMovie
import com.example.movie.ui.home.homeUiState.PopularUiState
import javax.inject.Inject


class PopularUiMapper @Inject constructor() : Mapper<PopularMovie, PopularUiState> {
    override fun map(input: PopularMovie): PopularUiState {
        return PopularUiState(
            input.movieID,
            input.title,
            input.imageUrl,
            input.movieRate,
            input.genre
        )
    }
}