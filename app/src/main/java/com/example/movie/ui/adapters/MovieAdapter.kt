package com.example.movie.ui.adapters

import com.example.movie.R
import com.example.movie.domain.enums.HomeItemsType
import com.example.movie.domain.models.Media
import com.example.movie.ui.base.BaseAdapter
import com.example.movie.ui.base.BaseInteractionListener
import com.example.movie.ui.models.MediaUiState

class MovieAdapter(items: List<MediaUiState>,val listener: MovieInteractionListener) :
    BaseAdapter<MediaUiState>(items, listener) {
    override val layoutID: Int = R.layout.item_movie
}

interface MovieInteractionListener : BaseInteractionListener {
    fun onClickMovie(movieId: Int)
    fun onClickSeeAllMovie(homeItemsType: HomeItemsType)
}

