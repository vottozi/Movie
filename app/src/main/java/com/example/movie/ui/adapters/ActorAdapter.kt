package com.example.movie.ui.adapters

import com.example.movie.ui.base.BaseAdapter
import com.example.movie.ui.base.BaseInteractionListener
import com.example.movie.ui.models.ActorUiState

class ActorAdapter(items: List<ActorUiState>, val layout: Int, val listener: ActorsInteractionListener) :
    BaseAdapter<ActorUiState>(items, listener) {
    override val layoutID: Int = layout
}

interface ActorsInteractionListener : BaseInteractionListener {
    fun onClickActor(actorID: Int)
}