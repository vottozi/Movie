package com.example.movie.ui.mappers

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import com.example.movie.ui.models.MediaUiState
import javax.inject.Inject

class MediaUiMapper @Inject constructor() : Mapper<Media, MediaUiState> {
    override fun map(input: Media): MediaUiState {
        return MediaUiState(
            input.mediaID,
            input.mediaImage,
        )
    }
}