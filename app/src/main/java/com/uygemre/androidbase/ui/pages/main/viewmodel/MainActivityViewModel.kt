package com.uygemre.androidbase.ui.pages.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.uygemre.androidbase.ui.pages.main.repository.MainActivityRepository
import com.uygemre.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Created by Emre UYGUN on 3.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    var repository: MainActivityRepository
) : BaseViewModel() {

    private val mutableSelectedItem = MutableLiveData<Int>()
    val selectedItem: LiveData<Int> get() = mutableSelectedItem

    fun selectItem(fragment: Int) {
        mutableSelectedItem.value = fragment
    }

}