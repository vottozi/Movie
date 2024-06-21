package com.example.movie.domain.mappers.series

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.RatedMoviesDto
import com.example.movie.data.remote.response.RatedTvShowDto
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Rated
import com.example.movie.utilities.Constants
import javax.inject.Inject

class RatedTvShowMapper @Inject constructor() : Mapper<RatedTvShowDto, Rated> {
    override fun map(input: RatedTvShowDto): Rated {
        return Rated(
            id = input.id ?: 0,
            title = input.title ?: "",
            posterPath = BuildConfig.IMAGE_BASE_PATH + input.backdropPath,
            rating = input.rating ?: 0F,
            releaseDate = "",
            mediaType = Constants.TV_SHOWS
        )
    }
}