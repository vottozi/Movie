package com.example.movie.ui.explore.exploreUIState

sealed interface ExploringUIEvent {
    object SearchEvent : ExploringUIEvent
    object MoviesEvent : ExploringUIEvent
    object TVShowEvent : ExploringUIEvent
    object ActorsEvent : ExploringUIEvent
    data class TrendEvent(val trendyMediaUIState: TrendyMediaUIState) : ExploringUIEvent
}