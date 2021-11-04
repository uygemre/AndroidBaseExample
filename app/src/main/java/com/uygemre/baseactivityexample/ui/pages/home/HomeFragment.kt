package com.uygemre.baseactivityexample.ui.pages.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uygemre.baseactivityexample.ui.base.BaseFragment
import com.uygemre.baseactivityexample.databinding.FragmentHomeBinding

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {

    override fun getViewModelClass(): Class<HomeFragmentViewModel> =
        HomeFragmentViewModel::class.java

    override fun getViewBindingInflater(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.tvHome.text = "Home Fragment"
    }
}