package com.example.movie.ui.actorDetails

import com.example.movie.R
import com.example.movie.domain.enums.HomeItemsType
import com.example.movie.ui.adapters.MovieInteractionListener

import com.example.movie.ui.base.BaseAdapter
import com.example.movie.ui.base.BaseInteractionListener

class ActorMoviesAdapter(items: List<ActorMoviesUIState>, val listener: MovieInteractionListener) :
    BaseAdapter<ActorMoviesUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_movie_actor
}