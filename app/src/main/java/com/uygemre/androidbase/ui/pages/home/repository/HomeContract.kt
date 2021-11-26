package com.uygemre.androidbase.ui.pages.home.repository

import com.uygemre.core.networking.DataFetchResult
import com.uygemre.data.response.NewsResponseModel
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

// Created by Emre UYGUN on 15.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

interface HomeContract {

    interface Remote {
        fun getCapsules(): Single<List<NewsResponseModel>>
    }

    interface Repository {
        val capsulesPublishSubject: PublishSubject<DataFetchResult<List<NewsResponseModel>>>
        fun getCapsules()

        fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable)
    }
}