package com.uygemre.androidbase.ui.pages.main.repository

import com.uygemre.core.modules.ApiInterface
import com.uygemre.core.modules.ApiServiceModule
import com.uygemre.data.response.NewsResponseModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// Created by Emre UYGUN on 15.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class MainActivityRepository @Inject constructor(
    private val api: ApiInterface
) {
}