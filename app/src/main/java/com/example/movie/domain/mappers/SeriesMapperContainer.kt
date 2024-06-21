package com.example.movie.domain.mappers

import com.example.movie.domain.mappers.actor.ActorDtoMapper
import com.example.movie.domain.mappers.series.*
import javax.inject.Inject

class SeriesMapperContainer @Inject constructor(
    val genreMapper: GenreMapper,
    val mediaMapper: TVShowMapper,
    val tvShowDetailsMapper: TvShowDetailsMapper,
    val actorMapper: ActorDtoMapper,
    val reviewMapper: ReviewMapper,
    val seasonMapper: SeasonMapper,
    val trailerMapper: TrailerMapper,
    val ratedTvShowMapper: RatedTvShowMapper,
    val airingTodaySeriesMapper: AiringTodaySeriesMapper,
    val onTheAirSeriesMapper: OnTheAirSeriesMapper,
    val topRatedSeriesMapper: TopRatedSeriesMapper,
    val episodeMapper: EpisodeMapper
)