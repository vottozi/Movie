package com.example.movie.domain.usecases

import com.example.movie.data.repository.MovieRepository
import com.example.movie.domain.mappers.MovieMappersContainer
import com.example.movie.domain.models.ActorDetails
import javax.inject.Inject

class GetActorDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMappersContainer: MovieMappersContainer,
) {
    suspend operator fun invoke(actorId: Int): ActorDetails {
        val response = movieRepository.getActorDetails(actorId = actorId)
        return if (response != null) {
            movieMappersContainer.actorDetailsMapper.map(response)
        } else {
            throw Throwable("Not Success")
        }
    }
}
