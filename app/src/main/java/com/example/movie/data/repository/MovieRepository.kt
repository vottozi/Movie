package com.example.movie.data.repository

import androidx.paging.Pager
import com.example.movie.data.local.database.entity.ActorEntity
import com.example.movie.data.local.database.entity.SearchHistoryEntity
import com.example.movie.data.local.database.entity.movie.*
import com.example.movie.data.remote.response.*
import com.example.movie.data.remote.response.actor.ActorDto
import com.example.movie.data.remote.response.actor.ActorMoviesDto
import com.example.movie.data.remote.response.genre.GenreDto
import com.example.movie.data.remote.response.movie.MovieDetailsDto
import com.example.movie.data.remote.response.movie.RatingDto
import com.example.movie.data.remote.response.review.ReviewsDto
import com.example.movie.data.remote.response.trailerVideosDto.TrailerDto
import com.example.movie.domain.models.*
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovieGenreList(): List<GenreDto>?

    suspend fun getDailyTrending(): BaseListResponse<DailyTrendingDto>

    suspend fun getMovieTrailer(movieId: Int): TrailerDto?

    suspend fun getActorDetails(actorId: Int): ActorDto?

    suspend fun getActorMovies(actorId: Int): ActorMoviesDto?

    suspend fun insertSearchItem(item: SearchHistoryEntity)

    suspend fun getAllMovies(): Pager<Int, MovieDto>

    suspend fun getMovieByGenre(genreID: Int): Pager<Int, MovieDto>

    suspend fun getPopularMovies(): Flow<List<PopularMovieEntity>>

    suspend fun getTrendingMovies(): Flow<List<TrendingMovieEntity>>

    suspend fun getNowStreamingMovies(): Flow<List<NowStreamingMovieEntity>>

    suspend fun getUpcomingMovies(): Flow<List<UpcomingMovieEntity>>

    suspend fun getAdventureMovies(): Flow<List<AdventureMovieEntity>>

    suspend fun getMysteryMovies(): Flow<List<MysteryMovieEntity>>

    suspend fun getTrendingActors(): Flow<List<ActorEntity>>

    suspend fun getTrendingMoviesPager(): Pager<Int, MovieDto>

    suspend fun getNowPlayingMoviesPager(): Pager<Int, MovieDto>

    suspend fun getUpcomingMoviesPager(): Pager<Int, MovieDto>

    suspend fun getActorMoviesPager(actorId: Int): Pager<Int, MovieDto>

    suspend fun getAdventureMoviesPager(): Pager<Int, MovieDto>

    suspend fun getMysteryMoviesPager(): Pager<Int, MovieDto>

    suspend fun searchForMoviePager(query: String): Pager<Int, MovieDto>

    suspend fun searchForActorPager(query: String): Pager<Int, ActorDto>

    suspend fun getAllSearchHistory(): Flow<List<SearchHistoryEntity>>

    suspend fun getActorData(): Pager<Int, ActorDto>

    suspend fun getMovieDetails(movieId: Int): MovieDetailsDto?

    suspend fun getMovieCast(movieId: Int): CreditsDto?

    suspend fun getSimilarMovie(movieId: Int): List<MovieDto>?

    suspend fun getMovieReviews(movieId: Int): List<ReviewsDto>?

    suspend fun setRating(movieId: Int, value: Float): RatingDto?

    suspend fun deleteRating(movieId: Int): RatingDto?

    suspend fun getRatedMovie(): List<RatedMoviesDto>?

}