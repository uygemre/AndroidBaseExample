package com.uygemre.core.modules

import com.uygemre.data.response.NewsResponseModel
import io.reactivex.Single
import retrofit2.http.GET

// Created by Emre UYGUN on 15.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

interface ApiInterface {

    @GET("capsules")
    fun getAllCapsules(): Single<List<NewsResponseModel>>
}