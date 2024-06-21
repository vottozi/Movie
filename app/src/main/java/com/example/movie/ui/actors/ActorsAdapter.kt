package com.example.movie.ui.actors

import androidx.recyclerview.widget.DiffUtil
import com.example.movie.R
import com.example.movie.ui.adapters.ActorsInteractionListener
import com.example.movie.ui.base.BasePagingAdapter
import com.example.movie.ui.models.ActorUiState

class ActorsAdapter(listener: ActorsInteractionListener) :
    BasePagingAdapter<ActorUiState>(ActorComparator, listener) {

    override val layoutID: Int = R.layout.item_actor_see_all

    object ActorComparator : DiffUtil.ItemCallback<ActorUiState>() {
        override fun areItemsTheSame(oldItem: ActorUiState, newItem: ActorUiState) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ActorUiState, newItem: ActorUiState) =
            oldItem == newItem
    }
}
