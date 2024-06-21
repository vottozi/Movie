package com.example.movie.ui.category.uiState

import com.example.movie.utilities.Constants

data class GenreUIState(
    val genreID: Int = Constants.FIRST_CATEGORY_ID,
    val genreName: String = ""
)
