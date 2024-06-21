package com.example.movie.ui.youtubePlayer

import com.example.movie.ui.category.uiState.ErrorUIState

data class TrailerUIState(
    val videoKey: String = "",
    val isLoading: Boolean = false,
    val error: List<ErrorUIState> = emptyList()
)