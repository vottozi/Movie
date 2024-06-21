package com.example.movie.domain.usecases.allMedia

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.example.movie.data.repository.MovieRepository
import com.example.movie.data.repository.SeriesRepository
import com.example.movie.domain.enums.AllMediaType
import com.example.movie.domain.mappers.movie.MovieMapper
import com.example.movie.domain.mappers.series.TVShowMapper
import com.example.movie.domain.models.Media
import com.example.movie.utilities.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMediaByTypeUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val seriesRepository: SeriesRepository,
    private val movieMapper: MovieMapper,
    private val tvShowMapper: TVShowMapper,
) {

    suspend operator fun invoke(type: AllMediaType, actorId: Int = 0): Flow<PagingData<Media>> {
        return when (type) {
            AllMediaType.ACTOR_MOVIES -> {
                wrapper({ movieRepository.getActorMoviesPager(actorId) }, movieMapper::map)
            }
            AllMediaType.LATEST,
            AllMediaType.AIRING_TODAY,
            -> {
                wrapper(seriesRepository::getAiringTodayTvShowPager, tvShowMapper::map)
            }
            AllMediaType.ON_THE_AIR -> {
                wrapper(seriesRepository::getTopRatedTvShowPager, tvShowMapper::map)
            }
            AllMediaType.POPULAR -> {
                wrapper(seriesRepository::getPopularTvShowPager, tvShowMapper::map)
            }
            AllMediaType.TOP_RATED -> {
                wrapper(seriesRepository::getTopRatedTvShowPager, tvShowMapper::map)
            }
            AllMediaType.TRENDING -> {
                wrapper(movieRepository::getTrendingMoviesPager, movieMapper::map)
            }
            AllMediaType.NOW_STREAMING -> {
                wrapper(movieRepository::getNowPlayingMoviesPager, movieMapper::map)
            }
            AllMediaType.UPCOMING -> {
                wrapper(movieRepository::getUpcomingMoviesPager, movieMapper::map)
            }
            AllMediaType.MYSTERY -> {
                wrapper({ movieRepository.getMovieByGenre(Constants.MYSTERY_ID) }, movieMapper::map)

            }
            AllMediaType.ADVENTURE -> {
                wrapper(
                    { movieRepository.getMovieByGenre(Constants.ADVENTURE_ID) },
                    movieMapper::map
                )
            }
        }
    }

    private suspend fun <T : Any> wrapper(
        data: suspend () -> Pager<Int, T>,
        mapper: (T) -> Media,
    ): Flow<PagingData<Media>> {
        return data().flow.map { pager -> pager.map { mapper(it) } }
    }
}