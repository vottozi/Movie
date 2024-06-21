package com.example.movie.ui.explore

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import com.example.movie.ui.explore.exploreUIState.TrendyMediaUIState
import javax.inject.Inject


class TrendingUIStateMapper @Inject constructor():
    Mapper<Media, TrendyMediaUIState> {
    override fun map(input: Media): TrendyMediaUIState {
        return TrendyMediaUIState(
            input.mediaID,
            input.mediaType,
            input.mediaImage
        )
    }
}
