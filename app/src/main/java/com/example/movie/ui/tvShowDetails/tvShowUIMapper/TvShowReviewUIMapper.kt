package com.example.movie.ui.tvShowDetails.tvShowUIMapper

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Review
import com.example.movie.ui.tvShowDetails.tvShowUIState.ReviewUIState
import javax.inject.Inject

class TvShowReviewUIMapper @Inject constructor() : Mapper<Review, ReviewUIState> {
    override fun map(input: Review): ReviewUIState {
        return ReviewUIState(
            content = input.content,
            createDate = input.createDate,
            userImage = input.userImage,
            name = input.name,
            userName = input.userName,
            rating = input.rating
        )
    }
}
