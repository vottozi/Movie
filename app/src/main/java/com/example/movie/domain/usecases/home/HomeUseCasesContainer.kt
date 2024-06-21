package com.example.movie.domain.usecases.home

import com.example.movie.domain.usecases.home.getData.GetTrendingActorsUseCase
import com.example.movie.domain.usecases.home.getData.series.GetAiringTodaySeriesUseCase
import com.example.movie.domain.usecases.home.getData.series.GetOnTheAirSeriesUseCase
import com.example.movie.domain.usecases.home.getData.series.GetTopRatedTvShowSeriesUseCase
import com.example.movie.domain.usecases.home.getData.movie.*

import javax.inject.Inject

class HomeUseCasesContainer @Inject constructor(
    val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    val getAiringTodayUseCase: GetAiringTodaySeriesUseCase,
    val getOnTheAirUseCase: GetOnTheAirSeriesUseCase,
    val getTopRatedTvShowUseCase: GetTopRatedTvShowSeriesUseCase,
    val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
    val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    val getMysteryMoviesUseCase: GetMysteryMoviesUseCase,
    val getAdventureMoviesUseCase: GetAdventureMoviesUseCase,
    val getNowStreamingMoviesUseCase: GetNowStreamingMoviesUseCase,
    val getTrendingActorsUseCase: GetTrendingActorsUseCase,
)