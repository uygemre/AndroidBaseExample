package com.uygemre.component

import com.uygemre.component.constants.RecyclerViewAdapterConstants
import com.uygemre.core.recyclerview.RecyclerViewAdapter
import dagger.hilt.EntryPoint

// Created by Emre UYGUN on 19.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class NewsRecyclerViewAdapter {

    fun getAdapter() = _adapter

    private val _adapter = RecyclerViewAdapter(
        viewBinderFactoryMap = RecyclerViewAdapterConstants().binderFactoryMap,
        viewHolderFactoryMap = RecyclerViewAdapterConstants().holderFactoryMap
    )
}