package com.example.movie.ui.search.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.movie.R
import com.example.movie.ui.base.*
import com.example.movie.ui.search.mediaSearchUIState.MediaUIState


class MediaSearchAdapter(listener: MediaSearchInteractionListener)
    : BasePagingAdapter<MediaUIState>(MediaSearchComparator, listener){
    override val layoutID: Int = R.layout.item_media_search

    object MediaSearchComparator : DiffUtil.ItemCallback<MediaUIState>(){
        override fun areItemsTheSame(oldItem: MediaUIState, newItem: MediaUIState) =
            oldItem.mediaID == newItem.mediaID

        override fun areContentsTheSame(oldItem: MediaUIState, newItem: MediaUIState) =
            oldItem == newItem
    }
}

interface MediaSearchInteractionListener : BaseInteractionListener {
    fun onClickMediaResult(media: MediaUIState)
}