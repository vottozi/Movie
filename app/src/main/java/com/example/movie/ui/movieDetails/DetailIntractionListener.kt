package com.example.movie.ui.movieDetails

import com.example.movie.ui.base.BaseInteractionListener

interface DetailInteractionListener :BaseInteractionListener {

    fun onclickBack()

    fun onClickSave()

    fun onClickPlayTrailer()

    fun onclickViewReviews()
}