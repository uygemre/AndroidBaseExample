package com.uygemre.baseactivityexample.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

// Created by Emre UYGUN on 3.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

abstract class BaseActivity<VB: ViewBinding, VM: ViewModel> : AppCompatActivity() {

    lateinit var viewBinding: VB
    lateinit var viewModel: VM

    @Inject
    @ActivityContext
    protected lateinit var viewModelProvider: ViewModelProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = getViewBindingInflater()
        viewModelProvider = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
        viewModel = viewModelProvider.get(getViewModelClass())
        setContentView(viewBinding.root)
    }


    abstract fun getViewModelClass(): Class<VM>
    abstract fun getViewBindingInflater(): VB
}