package com.uygemre.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

// Created by Emre UYGUN on 9.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    lateinit var viewBinding: VB
    abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = getViewBindingInflater(inflater, container)
        return viewBinding.root
    }

    abstract fun getViewBindingInflater(inflater: LayoutInflater, container: ViewGroup?): VB
}