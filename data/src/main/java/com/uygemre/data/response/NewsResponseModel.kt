package com.uygemre.data.response

import android.os.Parcelable

// Created by Emre UYGUN on 15.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@kotlinx.parcelize.Parcelize
data class NewsResponseModel(
    val status: String? = ""
) : Parcelable