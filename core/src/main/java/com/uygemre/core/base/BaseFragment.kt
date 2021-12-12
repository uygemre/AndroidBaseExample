package com.uygemre.core.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.kaopiz.kprogresshud.KProgressHUD

// Created by Emre UYGUN on 9.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(private val inflate: Inflate<VB>) :
    AppCompatDialogFragment() {

    abstract val viewModel: VM

    private var _binding: VB? = null
    val binding get() = _binding

    protected var kProgress: KProgressHUD? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(layoutInflater, container, false)
        return requireNotNull(binding?.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().intent?.let { _intent -> viewModel.handleIntent(_intent) }
        arguments?.let { _bundle -> viewModel.handleArguments(_bundle) }
        childFragmentManager.fragments.forEach {
            (it as? BaseFragment<*,*>)?.onNewIntent(requireActivity().intent)
        }

        kProgress = KProgressHUD.create(requireActivity())
            .setCancellable(true)
            .setLabel("Lütfen bekleyiniz")
            .setAnimationSpeed(2)
            .setDimAmount(0.5F)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
    }

    @CallSuper
    open fun onNewIntent(intent: Intent) {
        childFragmentManager.fragments.forEach {
            (it as? BaseFragment<*,*>)?.onNewIntent(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}