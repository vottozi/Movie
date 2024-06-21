package com.example.movie.ui.tvShowDetails.episodes

import com.example.movie.R
import com.example.movie.ui.base.BaseAdapter
import com.example.movie.ui.base.BaseInteractionListener

class EpisodeAdapter(items: List<EpisodesUIState>, listener: EpisodesInteractionListener) :
    BaseAdapter<EpisodesUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_episode
}

interface EpisodesInteractionListener : BaseInteractionListener