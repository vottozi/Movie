package com.example.movie.domain.usecases

import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.ActorMoviesMapper
import com.example.movie.domain.mappers.ListMapper
import com.example.movie.domain.models.ActorMovie
import javax.inject.Inject

class GetActorMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val actorMoviesMapper: ActorMoviesMapper,
) {

    suspend operator fun invoke(actorId: Int): List<ActorMovie> {
        val response = movieRepository.getActorMovies(actorId = actorId)
        return ListMapper(actorMoviesMapper).mapList(response?.cast)
    }
}