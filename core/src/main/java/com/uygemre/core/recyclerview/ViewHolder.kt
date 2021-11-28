package com.uygemre.core.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

// Created by Emre UYGUN on 13.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class ViewHolder<T>(viewBinding: ViewBinding) : RecyclerView.ViewHolder(viewBinding.root) {
    var itemClickListener: ((item: DisplayItem, position: Int) -> Unit)? = null
    var itemViewClickListener: ((view: View, item: DisplayItem, position: Int) -> Unit)? = null
    var itemLongClickListener: ((item: DisplayItem, position: Int) -> Boolean)? = null

    abstract fun bind(item: T)
}