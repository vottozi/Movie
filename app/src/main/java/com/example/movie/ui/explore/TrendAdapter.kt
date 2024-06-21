package com.example.movie.ui.explore

import com.example.movie.R
import com.example.movie.ui.base.*
import com.example.movie.ui.explore.exploreUIState.TrendyMediaUIState


class TrendAdapter(items: List<TrendyMediaUIState>, listener: TrendInteractionListener)
    : BaseAdapter<TrendyMediaUIState>(items, listener){
    override val layoutID: Int = R.layout.item_trend
}

interface TrendInteractionListener : BaseInteractionListener {
    fun onClickTrend(item: TrendyMediaUIState)
}