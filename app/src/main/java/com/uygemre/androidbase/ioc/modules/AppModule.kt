package com.uygemre.androidbase.ioc.modules

import com.uygemre.component.NewsRecyclerViewAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Created by Emre UYGUN on 24.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAdapter() = NewsRecyclerViewAdapter()
}