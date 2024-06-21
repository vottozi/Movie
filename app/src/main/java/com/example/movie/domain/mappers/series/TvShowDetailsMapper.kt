package com.example.movie.domain.mappers.series

import com.example.movie.BuildConfig
import com.example.movie.data.remote.response.tvShow.TvShowDetailsDto
import com.example.movie.domain.enums.MediaType
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.TvShowDetails
import com.example.movie.utilities.convertToDayMonthYearFormat
import javax.inject.Inject

class TvShowDetailsMapper @Inject constructor(
    private val seasonMapper: SeasonMapper,
) :
    Mapper<TvShowDetailsDto, TvShowDetails> {
    override fun map(input: TvShowDetailsDto): TvShowDetails {
        return TvShowDetails(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.posterPath,
            input.name ?: "",
            input.firstAirDate?.convertToDayMonthYearFormat() ?: "",
            input.genres?.map { it?.name }?.joinToString(", ") ?: "",
            input.numberOfSeasons ?: 0,
            input.voteCount ?: 0,
            input.voteAverage.toString().take(3),
            input.overview ?: "",
            input.season?.map { seasonMapper.map(it) } ?: emptyList(),
            MediaType.TV_SHOW
        )
    }
}