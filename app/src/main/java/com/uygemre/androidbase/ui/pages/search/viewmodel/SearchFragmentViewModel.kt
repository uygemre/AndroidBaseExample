package com.uygemre.androidbase.ui.pages.search.viewmodel

import android.widget.TextView
import com.uygemre.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@HiltViewModel
class SearchFragmentViewModel @Inject constructor(

) : BaseViewModel() {

    fun printEmre(textView: TextView) {
        textView.text = "Search"
    }
}