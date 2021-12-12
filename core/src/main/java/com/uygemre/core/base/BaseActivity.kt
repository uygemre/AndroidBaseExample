package com.uygemre.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.kaopiz.kprogresshud.KProgressHUD
import io.reactivex.disposables.CompositeDisposable

// Created by Emre UYGUN on 9.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

typealias Inflater<T> = (LayoutInflater) -> T

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel>(private val inflate: Inflater<VB>) :
    AppCompatActivity() {

    abstract val viewModel: VM

    private var _binding: VB? = null
    val binding get() = _binding

    protected var kProgress: KProgressHUD? = null

    private var destroyDisposable: CompositeDisposable? = null
    private var stopDisposable: CompositeDisposable? = null
    private var pauseDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        destroyDisposable = CompositeDisposable()
        _binding = inflate.invoke(layoutInflater)
        setContentView(binding?.root)
        viewModel.handleIntent(intent)

        kProgress = KProgressHUD.create(this)
            .setCancellable(true)
            .setLabel("Lütfen bekleyiniz")
            .setAnimationSpeed(2)
            .setDimAmount(0.5F)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
    }

    override fun onStart() {
        super.onStart()

        stopDisposable = CompositeDisposable()
    }

    override fun onStop() {
        super.onStop()

        stopDisposable?.dispose()
    }

    override fun onResume() {
        super.onResume()

        pauseDisposable = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()

        pauseDisposable?.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()

        destroyDisposable?.dispose()
    }



}