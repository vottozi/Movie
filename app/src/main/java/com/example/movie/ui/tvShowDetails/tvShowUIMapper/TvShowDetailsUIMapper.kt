package com.example.movie.ui.tvShowDetails.tvShowUIMapper

import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.TvShowDetails
import com.example.movie.ui.tvShowDetails.tvShowUIState.TvShowDetailsResultUIState
import javax.inject.Inject

class TvShowDetailsResultUIMapper @Inject constructor() : Mapper<TvShowDetails, TvShowDetailsResultUIState> {
    override fun map(input: TvShowDetails): TvShowDetailsResultUIState {
        return TvShowDetailsResultUIState(
            tvShowId = input.tvShowId,
            tvShowName = input.tvShowName,
            tvShowOverview = input.tvShowOverview,
            tvShowImage = input.tvShowImage,
            tvShowVoteAverage = input.tvShowVoteAverage,
            tvShowReview = input.tvShowReview,
            tvShowReleaseDate = input.tvShowReleaseDate,
            tvShowGenres = input.tvShowGenres,
            tvShowSeasonsNumber = input.tvShowSeasonsNumber
        )
    }
}
