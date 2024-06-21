package com.example.movie.domain.mappers

import com.example.movie.data.repository.mediaDataSource.movie.MovieByGenreDataSource
import com.example.movie.data.repository.mediaDataSource.movie.MovieDataSource
import com.example.movie.data.repository.mediaDataSource.series.TVShowDataSource
import com.example.movie.data.repository.mediaDataSource.series.TVShowsByGenreDataSource
import javax.inject.Inject

class MediaDataSourceContainer @Inject constructor(
    val movieByGenreDataSource: MovieByGenreDataSource,
    val tvShowsByGenreDataSource: TVShowsByGenreDataSource,
    val movieDataSource: MovieDataSource,
    val tvShowDataSource: TVShowDataSource
)