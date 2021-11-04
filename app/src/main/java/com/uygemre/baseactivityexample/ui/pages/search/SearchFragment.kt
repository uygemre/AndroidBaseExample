package com.uygemre.baseactivityexample.ui.pages.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uygemre.baseactivityexample.ui.base.BaseFragment
import com.uygemre.baseactivityexample.databinding.FragmentSearchBinding

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class SearchFragment: BaseFragment<FragmentSearchBinding, SearchFragmentViewModel>() {

    override fun getViewModelClass(): Class<SearchFragmentViewModel> = SearchFragmentViewModel::class.java

    override fun getViewBindingInflater(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.tvSearch.text = "Search Fragment"

    }
}