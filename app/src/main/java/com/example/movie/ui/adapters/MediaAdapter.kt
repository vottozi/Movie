package com.example.movie.ui.adapters

import com.example.movie.domain.models.Media
import com.example.movie.ui.base.BaseAdapter
import com.example.movie.ui.base.BaseInteractionListener
import com.example.movie.ui.models.MediaUiState

class MediaAdapter(items: List<MediaUiState>, layout: Int, listener: MediaInteractionListener) :
    BaseAdapter<MediaUiState>(items, listener) {
    override val layoutID: Int = layout
}

interface MediaInteractionListener : BaseInteractionListener {
    fun onClickMedia(mediaId: Int)
}