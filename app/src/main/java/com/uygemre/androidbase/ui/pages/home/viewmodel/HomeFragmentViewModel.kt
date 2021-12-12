package com.uygemre.androidbase.ui.pages.home.viewmodel

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.uygemre.androidbase.ui.pages.home.repository.HomeRepository
import com.uygemre.component.ui.news.NewsDTO
import com.uygemre.core.base.BaseViewModel
import com.uygemre.core.extension.toLiveData
import com.uygemre.core.networking.DataFetchResult
import com.uygemre.core.recyclerview.DisplayItem
import com.uygemre.data.response.NewsResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    var repository: HomeRepository
) : BaseViewModel() {

    val ps: PublishSubject<Int> = PublishSubject.create()
    val capsulesPublishSubject = PublishSubject.create<MutableList<DisplayItem>>()

    fun printEmre(textView: TextView) {
        textView.text = "Home"
        ps.subscribe {

        }.addTo(disposables)
    }

    val capsulesLiveData: LiveData<DataFetchResult<List<NewsResponseModel>>> =
        Transformations.map(repository.capsulesPublishSubject.toLiveData(disposables)) {
            when (it) {
                is DataFetchResult.Progress -> {
                }
                is DataFetchResult.Failure -> {
                }
                is DataFetchResult.Success -> {
                    val list = mutableListOf<DisplayItem>()
                    list.add(NewsDTO())
                    capsulesPublishSubject.onNext(list)
                }
            }
            it
        }

    fun getCapsules() {
        repository.getCapsules()
    }
}