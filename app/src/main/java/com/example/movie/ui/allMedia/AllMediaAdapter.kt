package com.example.movie.ui.allMedia

import androidx.recyclerview.widget.DiffUtil
import com.example.movie.R
import com.example.movie.ui.adapters.MediaInteractionListener
import com.example.movie.ui.base.BasePagingAdapter
import com.example.movie.ui.models.MediaUiState

open class AllMediaAdapter(listener: MediaInteractionListener) :
    BasePagingAdapter<MediaUiState>(MediaComparator, listener) {
    override val layoutID: Int = R.layout.item_media

    object MediaComparator : DiffUtil.ItemCallback<MediaUiState>() {
        override fun areItemsTheSame(oldItem: MediaUiState, newItem: MediaUiState) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MediaUiState, newItem: MediaUiState) =
            oldItem == newItem
    }

}