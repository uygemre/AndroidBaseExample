package com.uygemre.component.ui.news

import android.os.Parcelable
import com.uygemre.component.constants.RecyclerViewAdapterConstants.TYPES.TYPE_NEWS
import com.uygemre.core.recyclerview.DisplayItem
import kotlinx.parcelize.Parcelize

// Created by Emre UYGUN on 14.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@Parcelize
data class NewsDTO(
    val id: Int? = 0
) : Parcelable, DisplayItem(TYPE_NEWS)