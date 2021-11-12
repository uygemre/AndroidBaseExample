package com.uygemre.androidbase.ui.pages.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidbase.R
import androidbase.databinding.FragmentHomeBinding
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uygemre.core.base.BaseFragment
import com.uygemre.androidbase.ui.pages.home.viewmodel.HomeFragmentViewModel
import com.uygemre.androidbase.ui.pages.main.MainActivity
import com.uygemre.androidbase.ui.pages.main.viewmodel.MainActivityViewModel
import com.uygemre.core.extension.openActivity
import dagger.hilt.android.AndroidEntryPoint

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(R.layout.fragment_home) {

    override val viewModel: HomeFragmentViewModel by viewModels()
    override val viewBinding: FragmentHomeBinding by viewBinding()

    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnNavigate.setOnClickListener {
            mainActivityViewModel.selectItem(1)
        }

        requireContext().openActivity(MainActivity::class.java)
    }
}