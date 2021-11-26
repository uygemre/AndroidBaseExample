package com.uygemre.androidbase.ui.pages.main

import android.os.Bundle
import androidbase.R
import androidbase.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.uygemre.androidbase.ui.pages.home.HomeFragment
import com.uygemre.core.base.BaseActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uygemre.androidbase.ui.pages.main.viewmodel.MainActivityViewModel
import com.uygemre.androidbase.ui.pages.search.SearchFragment
import com.uygemre.core.extension.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseActivity<ActivityMainBinding, MainActivityViewModel>(R.layout.activity_main) {

    override val viewBinding: ActivityMainBinding by viewBinding()
    override val viewModel: MainActivityViewModel by viewModels()

    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.selectedItem.observe(this, { item ->
            var selectedId: Int? = null
            when (item) {
                0 -> {
                    fragment = HomeFragment()
                    selectedId = R.id.navigation_news
                }
                1 -> {
                    fragment = SearchFragment()
                    selectedId = R.id.navigation_search
                }
            }
            fragment?.let { _fragment ->
                replaceFragment(_fragment, viewBinding.container.id)
                viewBinding.bottomNavigationView.selectedItemId = selectedId ?: -1
            }
        })

        replaceFragment(HomeFragment(), viewBinding.container.id)
        viewBinding.bottomNavigationView.itemIconTintList = null
        viewBinding.bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.navigation_news -> {
                    fragment = HomeFragment()
                }
                R.id.navigation_search -> {
                    fragment = SearchFragment()
                }
            }

            fragment?.let {
                replaceFragment(it, viewBinding.container.id)
            }

            return@setOnItemSelectedListener true
        }
    }
}