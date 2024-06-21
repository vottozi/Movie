package com.example.movie.ui.category

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Genre
import com.example.movie.ui.category.uiState.GenreUIState
import javax.inject.Inject

class GenreUIStateMapper @Inject constructor() : Mapper<Genre, GenreUIState> {
    override fun map(input: Genre): GenreUIState {
        return GenreUIState(
            genreID = input.genreID,
            genreName = input.genreName
        )
    }
}