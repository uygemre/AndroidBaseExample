package com.uygemre.component.constants

import com.uygemre.component.ui.news.NewsViewHolder

// Created by Emre UYGUN on 19.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class RecyclerViewAdapterConstants {

    object TYPES {
        const val TYPE_NONE = 0
        const val TYPE_NEWS = 1
    }

    var binderFactoryMap = mutableMapOf(
        TYPES.TYPE_NEWS to NewsViewHolder.BinderFactory()
    )

    var holderFactoryMap = mutableMapOf(
        TYPES.TYPE_NEWS to NewsViewHolder.HolderFactory()
    )
}