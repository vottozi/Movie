package com.example.movie.ui.category

import androidx.recyclerview.widget.DiffUtil
import com.example.movie.R
import com.example.movie.ui.adapters.MediaInteractionListener
import com.example.movie.ui.base.BasePagingAdapter
import com.example.movie.ui.category.uiState.MediaUIState

class CategoryAdapter (listener: MediaInteractionListener) :
    BasePagingAdapter<MediaUIState>(MediaComparator, listener) {
    override val layoutID: Int = R.layout.item_category

    object MediaComparator : DiffUtil.ItemCallback<MediaUIState>() {
        override fun areItemsTheSame(oldItem: MediaUIState, newItem: MediaUIState) =
            oldItem.mediaID == newItem.mediaID

        override fun areContentsTheSame(oldItem: MediaUIState, newItem: MediaUIState) =
            oldItem == newItem
    }

}
