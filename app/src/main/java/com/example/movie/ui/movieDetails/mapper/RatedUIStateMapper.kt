package com.example.movie.ui.movieDetails.mapper

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Rated
import com.example.movie.ui.movieDetails.movieDetailsUIState.RatedUIState
import javax.inject.Inject

class RatedUIStateMapper @Inject constructor() : Mapper<Rated, RatedUIState> {
    override fun map(input: Rated): RatedUIState {
        return RatedUIState(
            id = input.id,
            rating = input.rating,
        )
    }
}