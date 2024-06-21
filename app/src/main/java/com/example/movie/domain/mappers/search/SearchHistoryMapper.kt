package com.example.movie.domain.mappers.search

import com.example.movie.data.local.database.entity.SearchHistoryEntity
import com.example.movie.domain.mappers.Mapper
import com.example.movie.domain.models.SearchHistory
import javax.inject.Inject

class SearchHistoryMapper @Inject constructor() : Mapper<SearchHistoryEntity, SearchHistory> {
    override fun map(input: SearchHistoryEntity): SearchHistory {
        return SearchHistory(
            id = input.id,
            name = input.search
        )
    }
}