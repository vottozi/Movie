package com.example.movie.domain.usecases.home.getData

import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.actor.ActorEntityMapper
import com.example.movie.domain.models.Actor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetTrendingActorsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val actorMapper: ActorEntityMapper,
) {

    suspend operator fun invoke(): Flow<List<Actor>> {
        return movieRepository.getTrendingActors().map {
            it.map(actorMapper::map)
        }
    }
}