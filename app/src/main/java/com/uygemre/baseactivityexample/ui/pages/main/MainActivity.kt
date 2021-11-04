package com.uygemre.baseactivityexample.ui.pages.main

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.uygemre.baseactivityexample.ui.pages.home.HomeFragment
import com.uygemre.baseactivityexample.ui.base.BaseActivity
import com.uygemre.baseactivityexample.databinding.ActivityMainBinding
import com.uygemre.baseactivityexample.ui.pages.search.SearchFragment

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override fun getViewBindingInflater(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<MainActivityViewModel> =
        MainActivityViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadFragment(HomeFragment())
        viewBinding.bottomNavigationView.itemIconTintList = null
        viewBinding.bottomNavigationView.setOnItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var fragment: Fragment? = null
                when (item.itemId) {
                    com.uygemre.baseactivityexample.R.id.navigation_news -> {
                        fragment = HomeFragment()
                    }
                    com.uygemre.baseactivityexample.R.id.navigation_search -> {
                        fragment = SearchFragment()
                    }
                }
                return loadFragment(fragment)
            }
        })
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