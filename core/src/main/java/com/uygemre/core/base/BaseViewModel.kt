package com.uygemre.core.base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

// Created by Emre UYGUN on 9.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class BaseViewModel : ViewModel() {

    protected val disposables = CompositeDisposable()

    @CallSuper
    override fun onCleared() = disposables.dispose()

    open fun handleIntent(intent: Intent) {}
    open fun handleArguments(argument: Bundle) {}
}