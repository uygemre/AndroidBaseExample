package com.uygemre.core.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uygemre.core.recyclerview.RecyclerViewAdapter

// Created by Emre UYGUN on 19.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

//@SuppressLint("WrongConstant")
fun RecyclerView.setup(
    adapter: RecyclerViewAdapter,
    layoutManager: LinearLayoutManager = LinearLayoutManager(this.context),
    isHasFixedSize: Boolean = false
) {
    this.layoutManager = layoutManager
    this.setHasFixedSize(isHasFixedSize)
    adapter.let {
        this.adapter = adapter
    }
}