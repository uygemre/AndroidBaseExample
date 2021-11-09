package com.uygemre.baseactivityexample.ui.pages.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.uygemre.baseactivityexample.ui.pages.home.HomeFragment
import com.uygemre.core.base.BaseActivity
import com.uygemre.baseactivityexample.databinding.ActivityMainBinding
import com.uygemre.baseactivityexample.ui.pages.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override fun getViewBindingInflater(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadFragment(HomeFragment())
        viewBinding.bottomNavigationView.itemIconTintList = null
        viewBinding.bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                com.uygemre.baseactivityexample.R.id.navigation_news -> {
                    fragment = HomeFragment()
                }
                com.uygemre.baseactivityexample.R.id.navigation_search -> {
                    fragment = SearchFragment()
                }
            }

            loadFragment(fragment)

            return@setOnItemSelectedListener true
        }
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        fragment?.let {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.container.id, fragment)
                .commit()
            return true
        }
        return false
    }
}