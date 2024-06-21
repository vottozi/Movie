package com.example.movie.ui.search.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.movie.R
import com.example.movie.ui.base.BaseInteractionListener
import com.example.movie.ui.base.BasePagingAdapter
import com.example.movie.ui.search.mediaSearchUIState.MediaUIState

class ActorSearchAdapter(listener: ActorSearchInteractionListener)
    : BasePagingAdapter<MediaUIState>(ActorSearchComparator, listener){
    override val layoutID: Int = R.layout.item_actor_search

    object ActorSearchComparator : DiffUtil.ItemCallback<MediaUIState>(){
        override fun areItemsTheSame(oldItem: MediaUIState, newItem: MediaUIState) =
            oldItem.mediaID == newItem.mediaID

        override fun areContentsTheSame(oldItem: MediaUIState, newItem: MediaUIState) =
            oldItem == newItem
    }
}

interface ActorSearchInteractionListener : BaseInteractionListener{
    fun onClickActorResult(personID: Int, name: String)
}