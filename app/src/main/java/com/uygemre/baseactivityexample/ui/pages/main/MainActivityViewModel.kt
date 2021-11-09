package com.uygemre.baseactivityexample.ui.pages.main

import android.widget.TextView
import com.uygemre.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Created by Emre UYGUN on 3.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@HiltViewModel
class MainActivityViewModel @Inject constructor(

) : BaseViewModel() {

    fun printEmre(textView: TextView) {
        textView.text = "Emre"
    }
}