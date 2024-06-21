package com.example.movie.domain.usecases

import androidx.paging.PagingData
import androidx.paging.map
import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.actor.ActorDtoMapper
import com.example.movie.domain.models.Actor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetActorsDataUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val actorMapper: ActorDtoMapper
) {
    suspend operator fun invoke(): Flow<PagingData<Actor>>{
        return movieRepository.getActorData().flow.map { pager -> pager.map { actorMapper.map(it) } }
    }
}
