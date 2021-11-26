package com.uygemre.androidbase.ui.pages.home.repository

import com.uygemre.core.modules.ApiInterface
import com.uygemre.data.response.NewsResponseModel
import io.reactivex.Single
import javax.inject.Inject

// Created by Emre UYGUN on 15.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class HomeRemoteData @Inject constructor(
    private val api: ApiInterface
) : HomeContract.Remote {

    override fun getCapsules(): Single<List<NewsResponseModel>> = api.getAllCapsules()
}