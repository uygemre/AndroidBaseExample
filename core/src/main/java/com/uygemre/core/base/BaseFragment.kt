package com.uygemre.core.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

// Created by Emre UYGUN on 9.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(layoutId: Int) : Fragment(layoutId) {

    abstract val viewBinding: VB
    abstract val viewModel: VM
}