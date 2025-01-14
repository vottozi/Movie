package com.example.movie.ui.tvShowDetails.episodes

import com.example.movie.ui.tvShowDetails.tvShowUIState.Error

data class EpisodesUIState(
    val seriesEpisodeUIState: List<EpisodeUIState> = listOf(),
    val isLoading: Boolean = false,
    val error: List<Error> = emptyList()
)