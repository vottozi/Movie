package com.example.movie.ui.tvShowDetails.tvShowUIState

import com.example.movie.ui.models.ActorUiState

data class TvShowDetailsUIState(
    val tvShowDetailsResult: TvShowDetailsResultUIState = TvShowDetailsResultUIState(),
    val seriesCastResult: List<ActorUiState> = listOf(),
    val seriesSeasonsResult: List<SeasonUIState> = listOf(),
    val seriesReviewsResult: List<ReviewUIState> = listOf(),
    val detailItemResult: List<DetailItemUIState> = listOf(),
    val ratingValue: Float = 0F,
    val isLoading: Boolean = false,
    val isLogin: Boolean = false,
    val errorUIState: List<Error> = emptyList()
)
