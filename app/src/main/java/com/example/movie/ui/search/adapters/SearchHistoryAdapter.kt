package com.example.movie.ui.search.adapters

import com.example.movie.R
import com.example.movie.ui.base.*
import com.example.movie.ui.search.mediaSearchUIState.SearchHistoryUIState


class SearchHistoryAdapter(items: List<SearchHistoryUIState>, listener: SearchHistoryInteractionListener)
    : BaseAdapter<SearchHistoryUIState>(items,listener){
    override val layoutID: Int = R.layout.item_search_history
}

interface SearchHistoryInteractionListener : BaseInteractionListener {
    fun onClickSearchHistory(name: String)
}