package com.example.movie.domain.mappers.series

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.SeasonDto
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.Season
import javax.inject.Inject

class SeasonMapper @Inject constructor(
    private val episodeMapper: EpisodeMapper
) : Mapper<SeasonDto, Season> {
    override fun map(input: SeasonDto): Season {
        return Season(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.posterPath,
            input.name ?: "",
            input.airDate ?: "",
            input.seasonNumber ?: 0,
            input.episodeCount ?: 0,
            input.overview ?: "",
            input.episodes?.map {
                episodeMapper.map(it)
            } ?: emptyList()
        )
    }
}