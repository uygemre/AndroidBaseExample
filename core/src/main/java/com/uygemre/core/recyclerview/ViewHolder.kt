package com.uygemre.core.recyclerview

import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

// Created by Emre UYGUN on 13.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class ViewHolder<T>(viewBinding: ViewBinding? = null) : RecyclerView.ViewHolder(viewBinding?.root!!) {
    var itemClickListener: ((item: DisplayItem, position: Int) -> Unit)? = null
    var itemViewClickListener: ((view: View, item: DisplayItem, position: Int) -> Unit)? = null
    var itemLongClickListener: ((item: DisplayItem, position: Int) -> Boolean)? = null

    abstract fun bind(item: T)
//    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
//    abstract fun bindViewHolder(holder: RecyclerView.ViewHolder, item: DisplayItem)

//    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
//    abstract fun bindViewHolder(holder: RecyclerView.ViewHolder, item: DisplayItem)
}