package com.uygemre.baseactivityexample.ui.pages.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.uygemre.core.base.BaseFragment
import com.uygemre.baseactivityexample.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {

    override val viewModel: HomeFragmentViewModel by viewModels()

    override fun getViewBindingInflater(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.printEmre(viewBinding.tvHome)
    }
}