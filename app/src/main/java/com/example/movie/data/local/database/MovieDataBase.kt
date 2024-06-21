package com.example.movie.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movie.data.local.database.daos.*
import com.example.movie.data.local.database.entity.*
import com.example.movie.data.local.database.entity.movie.*
import com.example.movie.data.local.database.entity.series.*

@Database(
    entities = [WatchList::class, SearchHistoryEntity::class, PopularMovieEntity::class,
        ActorEntity::class, TrendingMovieEntity::class, NowStreamingMovieEntity::class,UpcomingMovieEntity::class,
        MysteryMovieEntity::class,AdventureMovieEntity::class, AiringTodaySeriesEntity::class,
        OnTheAirSeriesEntity::class,TopRatedSeriesEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao
    abstract fun seriesDao(): SeriesDao
}