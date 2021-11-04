package com.uygemre.baseactivityexample.ui.pages.main

import android.widget.TextView
import com.uygemre.baseactivityexample.ui.base.BaseViewModel

// Created by Emre UYGUN on 3.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class MainActivityViewModel: BaseViewModel() {

    fun printEmre(textView: TextView) {
        textView.text = "Emre"
    }
}