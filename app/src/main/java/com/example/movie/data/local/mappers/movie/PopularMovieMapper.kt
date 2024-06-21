package com.example.movie.data.local.mappers.movie

import com.example.movie.BuildConfig
import com.example.movie.data.local.database.entity.movie.PopularMovieEntity
import com.example.movie.data.remote.response.MovieDto
import com.example.movie.data.remote.response.genre.GenreDto
import com.example.movie.domain.models.Genre
import javax.inject.Inject

class PopularMovieMapper @Inject constructor() {
    fun map(movie: MovieDto, genreList: List<GenreDto>): PopularMovieEntity {
        return PopularMovieEntity(
            id = movie.id ?: 0,
            title = movie.title ?: "",
            movieRate = movie.voteAverage ?: 0.0,
            imageUrl = (BuildConfig.IMAGE_BASE_PATH + movie.backdropPath),
            genre = getGenreNames(movie.genreIds, genreList)
        )
    }

    private fun getGenreNames(genreIds: List<Int>?, genreList: List<GenreDto>): List<String> {
        val genres = mutableListOf<String>()
        genreIds?.forEach { movieGenreID ->
            genres.add(genreList.find { it.id == movieGenreID }?.name ?: "")
        }
        return genres
    }

}