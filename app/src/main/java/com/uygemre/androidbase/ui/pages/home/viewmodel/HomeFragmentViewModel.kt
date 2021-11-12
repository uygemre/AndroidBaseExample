package com.uygemre.androidbase.ui.pages.home.viewmodel

import android.widget.TextView
import com.uygemre.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(

) : BaseViewModel() {

    val ps: PublishSubject<Int> = PublishSubject.create()

    fun printEmre(textView: TextView) {
        textView.text = "Home"
        ps.subscribe {

        }.addTo(disposables)
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}