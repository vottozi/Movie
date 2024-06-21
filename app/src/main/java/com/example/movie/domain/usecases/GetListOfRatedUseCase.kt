package com.example.movie.domain.usecases

import com.example.movie.data.repository.MovieRepository
import com.example.movie.data.repository.SeriesRepository
import com.example.movie.domain.mappers.ListMapper
import com.example.movie.domain.mappers.movie.RatedMoviesMapper
import com.example.movie.domain.mappers.series.RatedTvShowMapper
import com.example.movie.domain.models.Rated
import com.example.movie.utilities.margeTowList
import javax.inject.Inject

class GetListOfRatedUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: SeriesRepository,
    private val ratedMoviesMapper: RatedMoviesMapper,
    private val ratedTvShowMapper: RatedTvShowMapper
) {

    suspend operator fun invoke(): List<Rated> {
        return getRatedMovie().margeTowList(getRatedTvShow()).reversed()
    }

    private suspend fun getRatedMovie(): List<Rated> {
        return ListMapper(ratedMoviesMapper).mapList(movieRepository.getRatedMovie())
    }

    private suspend fun getRatedTvShow(): List<Rated> {
        return ListMapper(ratedTvShowMapper).mapList(tvShowRepository.getRatedTvShow())
    }
}