package com.uygemre.core.base

import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

// Created by Emre UYGUN on 9.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class BaseActivity<VB: ViewBinding, VM: BaseViewModel>(layoutId: Int) : AppCompatActivity(layoutId) {

    abstract val viewModel: VM
    abstract val viewBinding: VB
}