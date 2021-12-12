package com.uygemre.androidbase.ui.pages.detail

import android.os.Bundle
import android.view.View
import androidbase.R
import androidbase.databinding.FragmentDetailBinding
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.activityViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uygemre.androidbase.ui.pages.detail.viewmodel.DetailFragmentViewModel
import com.uygemre.core.base.BaseActivity
import com.uygemre.core.base.BaseFragment

// Created by Emre UYGUN on 29.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class DetailFragment : BaseActivity<FragmentDetailBinding, DetailFragmentViewModel>(FragmentDetailBinding::inflate) {

    override val viewModel: DetailFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}