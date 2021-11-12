package com.uygemre.androidbase.ui.pages.main.viewmodel

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uygemre.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Created by Emre UYGUN on 3.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@HiltViewModel
class MainActivityViewModel @Inject constructor(

) : BaseViewModel() {

    private val mutableSelectedItem = MutableLiveData<Int>()
    val selectedItem: LiveData<Int> get() = mutableSelectedItem

    fun selectItem(fragment: Int) {
        mutableSelectedItem.value = fragment
    }

    fun printEmre(textView: TextView) {
        textView.text = "Emre"
    }
}