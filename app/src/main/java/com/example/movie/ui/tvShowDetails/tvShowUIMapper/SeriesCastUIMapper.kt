package com.example.movie.ui.tvShowDetails.tvShowUIMapper

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Actor
import com.example.movie.ui.tvShowDetails.tvShowUIState.SeriesCastUIState
import javax.inject.Inject

class SeriesCastUIMapper @Inject constructor() : Mapper<Actor, SeriesCastUIState> {
    override fun map(input: Actor): SeriesCastUIState {
        return SeriesCastUIState(
            actorID = input.actorID,
            actorName = input.actorName,
            actorImage = input.actorImage
        )
    }
}
