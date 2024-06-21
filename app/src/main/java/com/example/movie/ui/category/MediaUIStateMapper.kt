package com.example.movie.ui.category

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import com.example.movie.ui.category.uiState.MediaUIState
import javax.inject.Inject

class MediaUIStateMapper @Inject constructor() : Mapper<Media, MediaUIState> {

    override fun map(input: Media): MediaUIState {
        return MediaUIState(
            mediaID = input.mediaID,
            mediaImage = input.mediaImage,
            mediaType = input.mediaType
        )
    }
}
