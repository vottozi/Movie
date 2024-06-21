package com.example.movie.ui.tvShowDetails.tvShowUIMapper

import com.example.movie.ui.tvShowDetails.episodes.TvShowEpisodesUIMapper
import javax.inject.Inject

class TvShowMapperContainer @Inject constructor(
    val tvShowDetailsUIMapper: TvShowDetailsResultUIMapper,
    val tvShowRatedUIMapper: TvShowRatedUIMapper,
    val tvShowCastUIMapper: SeriesCastUIMapper,
    val tvShowReviewUIMapper: TvShowReviewUIMapper,
    val tvShowSeasonUIMapper: TvShowSeasonUIMapper,
    val tvShowEpisodesUIMapper: TvShowEpisodesUIMapper
)
