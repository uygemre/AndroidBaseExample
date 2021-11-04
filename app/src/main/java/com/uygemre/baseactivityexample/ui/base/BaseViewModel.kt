package com.uygemre.baseactivityexample.ui.base

import android.app.Application
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

// Created by Emre UYGUN on 3.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class BaseViewModel: ViewModel() {

    @Inject
    protected lateinit var application: Application

    protected val disposables = CompositeDisposable()

    @CallSuper
    override fun onCleared() = disposables.dispose()
}