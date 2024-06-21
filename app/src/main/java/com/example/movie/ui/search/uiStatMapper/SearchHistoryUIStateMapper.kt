package com.example.movie.ui.search.uiStatMapper

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.SearchHistory
import com.example.movie.ui.search.mediaSearchUIState.SearchHistoryUIState
import javax.inject.Inject


class SearchHistoryUIStateMapper @Inject constructor(): Mapper<SearchHistory, SearchHistoryUIState> {
    override fun map(input: SearchHistory): SearchHistoryUIState {
        return SearchHistoryUIState(
            input.name
        )
    }
}