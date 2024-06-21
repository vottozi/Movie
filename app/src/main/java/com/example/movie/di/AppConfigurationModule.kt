package com.example.movie.di

import com.example.movie.data.local.AppConfiguration
import com.example.movie.data.local.AppConfigurator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppConfigurationModule {

    @Binds
    @Singleton
    abstract fun bindAppConfiguration(appConfigurator: AppConfigurator): AppConfiguration
}
