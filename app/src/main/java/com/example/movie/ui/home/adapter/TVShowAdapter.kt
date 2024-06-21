package com.example.movie.ui.home.adapter

import com.example.movie.R
import com.example.movie.domain.enums.AllMediaType
import com.example.movie.domain.models.Media
import com.example.movie.ui.base.BaseAdapter
import com.example.movie.ui.base.BaseInteractionListener
import com.example.movie.ui.models.MediaUiState

class TVShowAdapter(items: List<MediaUiState>,val listener: TVShowInteractionListener) :
    BaseAdapter<MediaUiState>(items, listener) {
    override val layoutID: Int = R.layout.item_tvshow
}

interface TVShowInteractionListener : BaseInteractionListener {
    fun onClickTVShow(tVShowID: Int)
    fun onClickSeeTVShow(type: AllMediaType)
}
