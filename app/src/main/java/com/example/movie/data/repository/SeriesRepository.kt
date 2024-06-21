package com.example.movie.data.repository

import androidx.paging.Pager
import com.example.movie.data.local.database.entity.movie.AdventureMovieEntity
import com.example.movie.data.local.database.entity.series.AiringTodaySeriesEntity
import com.example.movie.data.local.database.entity.series.OnTheAirSeriesEntity
import com.example.movie.data.local.database.entity.series.TopRatedSeriesEntity
import com.example.movie.data.remote.response.CreditsDto
import com.example.movie.data.remote.response.RatedTvShowDto
import com.example.movie.data.remote.response.TVShowsDTO
import com.example.movie.data.remote.response.episode.EpisodeDto
import com.example.movie.data.remote.response.genre.GenreDto
import com.example.movie.data.remote.response.movie.RatingDto
import com.example.movie.data.remote.response.review.ReviewsDto
import com.example.movie.data.remote.response.trailerVideosDto.TrailerDto
import com.example.movie.data.remote.response.tvShow.TvShowDetailsDto
import com.example.movie.domain.models.*
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {

    suspend fun getTVShowsGenreList(): List<GenreDto>?

    suspend fun getTvShowTrailer(tvShowId: Int): TrailerDto?

    suspend fun getAllTVShows(): Pager<Int, TVShowsDTO>

    suspend fun getTVShowByGenre(genreID: Int): Pager<Int, TVShowsDTO>

    suspend fun getAiringToday(): Flow<List<AiringTodaySeriesEntity>>

    suspend fun getOnTheAir(): Flow<List<OnTheAirSeriesEntity>>

    suspend fun getTopRatedTvShow(): Flow<List<TopRatedSeriesEntity>>

    fun getAiringTodayTvShowPager(): Pager<Int, TVShowsDTO>

    fun getOnTheAirTvShowPager(): Pager<Int, TVShowsDTO>

    fun getTopRatedTvShowPager(): Pager<Int, TVShowsDTO>

    fun getPopularTvShowPager(): Pager<Int, TVShowsDTO>

    suspend fun searchForSeriesPager(query: String): Pager<Int, TVShowsDTO>

    suspend fun getTvShowDetails(tvShowId: Int): TvShowDetailsDto?

    suspend fun getTvShowCast(tvShowId: Int): CreditsDto?

    suspend fun getTvShowReviews(tvShowId: Int): List<ReviewsDto>?

    suspend fun setRating(tvShowId: Int, value: Float): RatingDto?

    suspend fun getRatedTvShow(): List<RatedTvShowDto>?

    suspend fun getSeasonDetails(tvShowId: Int, seasonId: Int): List<EpisodeDto>?

    suspend fun deleteTvShowRating(tvId: Int): RatingDto?


}