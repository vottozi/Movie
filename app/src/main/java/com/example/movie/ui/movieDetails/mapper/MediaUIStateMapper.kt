package com.example.movie.ui.movieDetails.mapper

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Media
import com.example.movie.ui.models.MediaUiState
import javax.inject.Inject

class MediaUIStateMapper @Inject constructor() : Mapper<Media, MediaUiState> {
    override fun map(input: Media): MediaUiState {
        return MediaUiState(
            id = input.mediaID,
            imageUrl = input.mediaImage,
        )
    }
}