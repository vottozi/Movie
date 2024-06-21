package com.example.movie.ui.tvShowDetails

import com.example.movie.R
import com.example.movie.domain.models.Season
import com.example.movie.ui.base.BaseAdapter
import com.example.movie.ui.base.BaseInteractionListener
import com.example.movie.ui.tvShowDetails.tvShowUIState.SeasonUIState

class SeasonAdapterUIState(
    items: List<SeasonUIState>,
    listener: SeasonInteractionListener
) : BaseAdapter<SeasonUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_season
}

interface SeasonInteractionListener : BaseInteractionListener {
    fun onClickSeason(seasonNumber: Int)
}
