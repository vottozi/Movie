package com.example.movie.ui.search.uiStatMapper

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import com.example.movie.ui.search.mediaSearchUIState.MediaUIState
import javax.inject.Inject


class SearchMediaUIStateMapper @Inject constructor(): Mapper<Media, MediaUIState> {
    override fun map(input: Media): MediaUIState {
        return MediaUIState(
            input.mediaID,
            input.mediaName,
            input.mediaImage,
            input.mediaType,
            input.mediaRate,
            input.mediaDate
        )
    }
}