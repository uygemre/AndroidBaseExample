package com.uygemre.androidbase.ioc.modules

import android.content.Context
import com.uygemre.component.NewsRecyclerViewAdapter
import com.uygemre.core.helpers.DataStoreHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

// Created by Emre UYGUN on 24.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@Module
@InstallIn(SingletonComponent::class)
object RecyclerAdapterModule {

    @Provides
    fun provideAdapter(): NewsRecyclerViewAdapter {
        return NewsRecyclerViewAdapter()
    }

    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStoreHelper =
        DataStoreHelper(context)
}