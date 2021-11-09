package com.uygemre.core.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

// Created by Emre UYGUN on 9.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class BaseActivity<VB: ViewBinding, VM: BaseViewModel>: AppCompatActivity() {

    lateinit var viewBinding: VB
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = getViewBindingInflater()

        setContentView(viewBinding.root)
    }

    abstract fun getViewBindingInflater(): VB
}