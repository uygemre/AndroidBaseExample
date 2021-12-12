package com.uygemre.component.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uygemre.component.databinding.NewsBinding
import com.uygemre.core.recyclerview.*
import javax.inject.Inject

// Created by Emre UYGUN on 14.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class NewsViewHolder(val binding: NewsBinding) : ViewHolder<NewsDTO>(binding) {

    override fun bind(item: NewsDTO) {
        binding.tvTitle.text = "Emre"
        binding.tvTitle.setOnClickListener {
            itemViewClickListener?.invoke(it, item, bindingAdapterPosition)
        }
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