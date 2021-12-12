package com.uygemre.androidbase.application

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

// Created by Emre UYGUN on 7.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@HiltAndroidApp
class Application : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: Application? = null

        fun getAppContext(): Context? = instance?.applicationContext
        fun getInstance(): Application? = instance
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}