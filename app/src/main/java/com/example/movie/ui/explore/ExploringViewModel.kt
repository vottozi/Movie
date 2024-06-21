package com.example.movie.ui.explore

import androidx.lifecycle.viewModelScope
import com.example.movie.domain.usecases.GetTrendingMovieUseCase
import com.example.movie.ui.base.BaseViewModel
import com.example.movie.ui.explore.exploreUIState.ErrorUIState
import com.example.movie.ui.explore.exploreUIState.ExploreUIState
import com.example.movie.ui.explore.exploreUIState.ExploringUIEvent
import com.example.movie.ui.explore.exploreUIState.TrendyMediaUIState
import com.example.movie.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ExploringViewModel @Inject constructor(
    private val getTrendyMovieUseCase: GetTrendingMovieUseCase,
    private val trendingUIStateMapper: TrendingUIStateMapper
) : BaseViewModel(), TrendInteractionListener {

    private val _uiState = MutableStateFlow(ExploreUIState())
    val uiState: StateFlow<ExploreUIState> = _uiState

    private val _exploringUIEvent: MutableStateFlow<Event<ExploringUIEvent>?> = MutableStateFlow(null)
    val exploringUIEvent= _exploringUIEvent.asStateFlow()

    init {
        getData()
    }

    override fun getData() {
        _uiState.update { it.copy(isLoading = true, error = emptyList()) }
        viewModelScope.launch {
            try {
                val result = getTrendyMovieUseCase()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        trendyMovie = result.map { trendingUIStateMapper.map(it) })
                }
            } catch (e: Throwable) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = listOf(ErrorUIState(404, ""))
                    )
                }
            }
        }
    }

    override fun onClickTrend(item: TrendyMediaUIState) {
        _exploringUIEvent.update { Event(ExploringUIEvent.TrendEvent(item)) }
    }

    fun onClickSearch() {
        _exploringUIEvent.update { Event(ExploringUIEvent.SearchEvent) }
    }

    fun onClickMovies() {
        _exploringUIEvent.update { Event(ExploringUIEvent.MoviesEvent) }
    }

    fun onClickTVShow() {
        _exploringUIEvent.update { Event(ExploringUIEvent.TVShowEvent) }
    }

    fun onClickActors() {
        _exploringUIEvent.update { Event(ExploringUIEvent.ActorsEvent) }
    }

}