package com.example.movie.domain.usecases

import com.example.movie.data.repository.MovieRepository
import com.example.movie.data.repository.SeriesRepository
import com.example.movie.domain.enums.MediaType
import com.example.movie.domain.mappers.TrailerMapper
import com.example.movie.domain.models.Trailer
import javax.inject.Inject

class GetTrailerUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val seriesRepository: SeriesRepository,
    private val trailerMapper: TrailerMapper
) {

    suspend operator fun invoke(mediaType: MediaType, mediaID: Int): Trailer {
        val result = when (mediaType) {
            MediaType.MOVIE -> {
                movieRepository.getMovieTrailer(mediaID)
            }
            MediaType.TV_SHOW -> {
                seriesRepository.getTvShowTrailer(mediaID)
            }
        }
        return result?.let { trailerMapper.map(it) } ?: throw Throwable("Error")
    }
}