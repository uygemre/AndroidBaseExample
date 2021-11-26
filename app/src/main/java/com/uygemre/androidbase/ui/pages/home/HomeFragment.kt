package com.uygemre.androidbase.ui.pages.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidbase.R
import androidbase.databinding.FragmentHomeBinding
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kaopiz.kprogresshud.KProgressHUD
import com.uygemre.core.base.BaseFragment
import com.uygemre.androidbase.ui.pages.home.viewmodel.HomeFragmentViewModel
import com.uygemre.component.NewsRecyclerViewAdapter
import com.uygemre.core.extension.setup
import com.uygemre.core.networking.DataFetchResult
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(R.layout.fragment_home) {

    override val viewBinding: FragmentHomeBinding by viewBinding()
    override val viewModel: HomeFragmentViewModel by viewModels()

    @Inject
    lateinit var adapter: NewsRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindObserver()
        viewBinding.rvCapsules.setup(adapter.getAdapter())
    }

    private fun bindObserver() {
        viewModel.getCapsules()
        viewModel.capsulesLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is DataFetchResult.Progress -> {
                }
                is DataFetchResult.Failure -> {
                }
                is DataFetchResult.Success -> {
                }
            }
        })
        viewModel.capsulesPublishSubject.subscribe { data ->
            adapter.getAdapter().updateAllItems(data)
        }.isDisposed
    }
}