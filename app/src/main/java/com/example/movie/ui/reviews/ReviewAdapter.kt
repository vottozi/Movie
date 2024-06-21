package com.example.movie.ui.reviews

import com.example.movie.R
import com.example.movie.domain.models.Review
import com.example.movie.ui.base.BaseAdapter
import com.example.movie.ui.base.BaseInteractionListener

class ReviewAdapter(items: List<Review>, listener: BaseInteractionListener
): BaseAdapter<Review>(items, listener) {
    override val layoutID: Int = R.layout.item_movie_review
}