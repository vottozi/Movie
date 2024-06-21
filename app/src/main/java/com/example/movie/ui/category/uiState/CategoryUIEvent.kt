package com.example.movie.ui.category.uiState

import com.example.movie.utilities.Constants

sealed class CategoryUIEvent {
    object RetryEvent : CategoryUIEvent()
    data class ClickMovieEvent(val movieID: Int) : CategoryUIEvent()
    data class SelectedCategory(val categoryID: Int = Constants.FIRST_CATEGORY_ID) :
        CategoryUIEvent()
}