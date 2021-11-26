package com.uygemre.androidbase.ui.pages.home.repository

import com.uygemre.core.extension.*
import com.uygemre.core.networking.DataFetchResult
import com.uygemre.core.networking.Scheduler
import com.uygemre.data.response.NewsResponseModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import javax.inject.Inject

// Created by Emre UYGUN on 15.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class HomeRepository @Inject constructor(
    private val remote: HomeRemoteData,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : HomeContract.Repository {

    override val capsulesPublishSubject = PublishSubject.create<DataFetchResult<List<NewsResponseModel>>>()

    override fun getCapsules() {
        capsulesPublishSubject.loading(true)
        remote.getCapsules()
            .performOnBackOutOnMain(scheduler)
            .subscribe(
                { response ->
                    capsulesPublishSubject.success(response)
                },
                { error ->
                    handleError(capsulesPublishSubject, error)
                }
            ).addTo(compositeDisposable)
    }

    override fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable) {
        result.failed(error)
        Timber.e(error.localizedMessage)
    }
}