package com.example.movie.domain.mappers

import com.example.movie.domain.mappers.actor.ActorDetailsMapper
import com.example.movie.domain.mappers.actor.ActorDtoMapper
import com.example.movie.domain.mappers.actor.ActorEntityMapper
import com.example.movie.domain.mappers.movie.*
import com.example.movie.domain.mappers.search.SearchActorMapper
import com.example.movie.domain.mappers.search.SearchHistoryMapper
import com.example.movie.domain.mappers.search.SearchSeriesMapper
import javax.inject.Inject

class MovieMappersContainer @Inject constructor(
    val movieMapper: MovieMapper,
    val popularMovieMapper: PopularMovieMapper,
    val genreMapper: GenreMapper,
    val movieDetailsMapper: MovieDetailsMapper,
    val reviewMapper: ReviewMapper,
    val trailerMapper: TrailerMapper,
    val ratedMoviesMapper: RatedMoviesMapper,
    val actorDetailsMapper: ActorDetailsMapper,
    val actorMapper: ActorDtoMapper,
    val searchActorMapper: SearchActorMapper,
    val seriesMapper: SearchSeriesMapper,
    val searchHistoryMapper: SearchHistoryMapper,
    val itemListMapper: ItemListMapper,
    val actorEntityMapper: ActorEntityMapper,
    val adventureMovieMapper: AdventureMovieMapper,
    val mysteryMovieMapper: MysteryMovieMapper,
    val nowStreamingMovieMapper: NowStreamingMovieMapper,
    val popularMovieEntityMapper: PopularMovieMapper,
    val trendingMapper: TrendingMovieMapper,
    val upcomingMovieMapper: UpcomingMovieMapper,


    )