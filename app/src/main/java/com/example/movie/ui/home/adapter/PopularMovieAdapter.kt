package com.example.movie.ui.home.adapter

import com.example.movie.R
import com.example.movie.ui.base.BaseAdapter
import com.example.movie.ui.home.HomeInteractionListener
import com.example.movie.ui.home.homeUiState.PopularUiState

class PopularMovieAdapter(items: List<PopularUiState>, listener: HomeInteractionListener) :
    BaseAdapter<PopularUiState>(items, listener) {
    override val layoutID: Int = R.layout.item_popular_movie
}

