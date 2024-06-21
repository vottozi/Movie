package com.example.movie.domain.mappers

import com.example.movie.data.remote.response.review.ReviewsDto
import com.example.movie.domain.models.Review
import javax.inject.Inject

class ReviewMapper @Inject constructor() : Mapper<ReviewsDto, Review> {
    override fun map(input: ReviewsDto): Review {
        return Review(
            content = input.content ?: "",
            createDate = input.createdAt?.take(10) ?: "",
            userImage = input.authorDetails?.avatarPath ?: "",
            name = input.authorDetails?.name ?: "GUEST",
            userName = input.authorDetails?.username ?: "GUEST",
            rating = input.authorDetails?.rating?.toFloat() ?: 0f
        )
    }
}