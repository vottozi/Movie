package com.example.movie.domain.usecases.home.getData.movie

import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.GenreMapper
import com.example.movie.domain.models.Genre
import javax.inject.Inject

class GetMovieGenreListUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val genreMapper: GenreMapper
) {
    suspend operator fun invoke(): List<Genre> {
        val result = movieRepository.getMovieGenreList()
        result?.let {
            return it.map { genreMapper.map(it) }
        } ?: throw Throwable("error")
    }
}