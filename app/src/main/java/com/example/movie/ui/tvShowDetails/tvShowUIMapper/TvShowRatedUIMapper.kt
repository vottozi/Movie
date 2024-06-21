package com.example.movie.ui.tvShowDetails.tvShowUIMapper

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Rated
import com.example.movie.ui.tvShowDetails.tvShowUIState.RatedUIState
import javax.inject.Inject

class TvShowRatedUIMapper @Inject constructor() : Mapper<Rated, RatedUIState> {
    override fun map(input: Rated): RatedUIState {
        return RatedUIState(
            id = input.id,
            rating = input.rating,
        )
    }
}
