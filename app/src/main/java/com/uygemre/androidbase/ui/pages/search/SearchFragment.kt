package com.uygemre.androidbase.ui.pages.search

import android.os.Bundle
import android.view.View
import androidbase.R
import androidbase.databinding.FragmentSearchBinding
import androidx.fragment.app.viewModels
import com.uygemre.core.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uygemre.androidbase.ui.pages.search.viewmodel.SearchFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchFragmentViewModel>(R.layout.fragment_search) {

    override val viewModel: SearchFragmentViewModel by viewModels()
    override val viewBinding: FragmentSearchBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.tvSearch.let {
            viewModel.printEmre(it)
        }
    }
}