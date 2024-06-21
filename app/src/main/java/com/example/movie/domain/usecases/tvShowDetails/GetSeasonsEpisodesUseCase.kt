package com.example.movie.domain.usecases.tvShowDetails

import com.example.movie.data.repository.SeriesRepository
import com.example.movie.domain.mappers.series.EpisodeMapper
import com.example.movie.domain.models.Episode
import javax.inject.Inject

class GetSeasonsEpisodesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val episodeMapper: EpisodeMapper,
) {
    suspend operator fun invoke(tvShowId: Int, seasonId: Int): List<Episode> {
        return seriesRepository.getSeasonDetails(tvShowId, seasonId)?.map(episodeMapper::map) ?: emptyList()
    }
}