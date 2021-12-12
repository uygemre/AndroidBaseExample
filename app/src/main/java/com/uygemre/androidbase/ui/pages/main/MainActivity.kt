package com.uygemre.androidbase.ui.pages.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidbase.R
import androidbase.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.uygemre.core.base.BaseActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uygemre.androidbase.ui.pages.main.viewmodel.MainActivityViewModel
import com.uygemre.core.helpers.DataStoreHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@AndroidEntryPoint
class MainActivity :
    BaseActivity<ActivityMainBinding, MainActivityViewModel>(ActivityMainBinding::inflate) {

    override val viewModel: MainActivityViewModel by viewModels()

    lateinit var navHostFragment: FragmentContainerView

    @Inject
    lateinit var dataStore: DataStoreHelper

    //var fragment: Fragment? = null

    private val strKey = stringPreferencesKey("test")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            dataStore.push(strKey, "EMRE")
            dataStore.pull(strKey, "emptyValue")?.collect { value: String ->
                Toast.makeText(this@MainActivity, value, Toast.LENGTH_SHORT).show()
            }
        }

        binding?.bottomNavigationView?.setupWithNavController(
            (supportFragmentManager.findFragmentById(
                binding?.navHostFragmentContainer?.id!!
            ) as NavHostFragment).navController
        )


//        viewModel.selectedItem.observe(this, { item ->
//            var selectedId: Int? = null
//            when (item) {
//                0 -> {
//                    fragment = HomeFragment()
//                    selectedId = R.id.navigation_news
//                }
//                1 -> {
//                    fragment = SearchFragment()
//                    selectedId = R.id.navigation_search
//                }
//            }
//            fragment?.let { _fragment ->
//                replaceFragment(_fragment, viewBinding.container.id)
//                viewBinding.bottomNavigationView.selectedItemId = selectedId ?: -1
//            }
//        })
//
//        replaceFragment(HomeFragment(), viewBinding.container.id)
//        viewBinding.bottomNavigationView.itemIconTintList = null
//        viewBinding.bottomNavigationView.setOnItemSelectedListener { item ->
//            var fragment: Fragment? = null
//            when (item.itemId) {
//                R.id.navigation_news -> {
//                    fragment = HomeFragment()
//                }
//                R.id.navigation_search -> {
//                    fragment = SearchFragment()
//                }
//            }
//
//            fragment?.let {
//                replaceFragment(it, viewBinding.container.id)
//            }
//
//            return@setOnItemSelectedListener true
//        }
    }
}