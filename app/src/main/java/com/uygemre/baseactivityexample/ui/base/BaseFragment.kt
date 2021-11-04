package com.uygemre.baseactivityexample.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel> : Fragment() {

    lateinit var viewBinding: VB
    lateinit var viewModel: VM

    @Inject
    @ActivityContext
    protected lateinit var viewModelProvider: ViewModelProvider


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = getViewBindingInflater(inflater, container)
        viewModelProvider = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application) )
        viewModel = viewModelProvider.get(getViewModelClass())
        return viewBinding.root
    }


    abstract fun getViewModelClass(): Class<VM>
    abstract fun getViewBindingInflater(inflater: LayoutInflater, container: ViewGroup?): VB
}