package com.uygemre.core.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// Created by Emre UYGUN on 14.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class RecyclerViewAdapter constructor(
    val items: MutableList<DisplayItem> = ArrayList(),
    private val viewHolderFactoryMap: Map<Int, ViewHolderFactory>,
    private val viewBinderFactoryMap: Map<Int, ViewHolderBinder>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolderFactoryMap[viewType]?.createViewHolder(parent)!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        viewBinderFactoryMap[items[position].type]?.bind(holder, items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].type

    fun updateAllItems(newItems: List<DisplayItem>) {
        updateItems(newItems)
        notifyDataSetChanged()
    }

    fun updateItems(newItems: List<DisplayItem>) {
        items.run {
            clear()
            addAll(newItems)
        }
    }
}