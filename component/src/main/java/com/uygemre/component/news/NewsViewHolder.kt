package com.uygemre.component.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uygemre.component.databinding.NewsBinding
import com.uygemre.core.recyclerview.*
import javax.inject.Inject

// Created by Emre UYGUN on 14.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class NewsViewHolder(val viewBinding: NewsBinding) : ViewHolder<NewsDTO>(viewBinding) {

    override fun bind(item: NewsDTO) {
        viewBinding.tvTitle.text = item.id.toString()
    }

    class HolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            return NewsViewHolder(
                NewsBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    class BinderFactory @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as NewsViewHolder).bind(item as NewsDTO)
        }
    }
}