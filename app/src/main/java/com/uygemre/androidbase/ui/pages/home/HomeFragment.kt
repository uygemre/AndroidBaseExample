package com.uygemre.androidbase.ui.pages.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidbase.R
import androidbase.databinding.FragmentHomeBinding
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.rxjava2.RxDataStore
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.uygemre.core.base.BaseFragment
import com.uygemre.androidbase.ui.pages.home.viewmodel.HomeFragmentViewModel
import com.uygemre.component.NewsRecyclerViewAdapter
import com.uygemre.core.extension.setup
import com.uygemre.core.helpers.DataStoreHelper
import com.uygemre.core.networking.DataFetchResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.properties.ReadOnlyProperty

// Created by Emre UYGUN on 4.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeFragmentViewModel by viewModels()

    @Inject
    lateinit var adapter: NewsRecyclerViewAdapter

//    @Inject
//    lateinit var dataStore: Data

    private var textViewValue = ""
    private val USER_FIRST_NAME = stringPreferencesKey("user_first_name")

    private val USER_PREFERENCES_NAME = "user_preferences"

//    private val Context.dataStore by preferencesDataStore(
//        name = USER_PREFERENCES_NAME
//    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindObserver()
        //dataStore = DataStoreHelper(requireContext())
//        GlobalScope.launch {
//            dataStore.push(USER_FIRST_NAME, "uygemre")
//            Timber.tag("dataStore").d((dataStore.pull(USER_FIRST_NAME, "").toString()))
//        }

//        requireActivity().lifecycleScope.launch {
//            requireContext().dataStore.edit { preferences ->
//                preferences[USER_FIRST_NAME] = "uygemre"
//            }
//        }

        binding?.rvCapsules?.setup(adapter.getAdapter())
        adapter.getAdapter().itemViewClickListener = { _view, _, _ ->
            when (_view.id) {
                R.id.tv_title -> {
                    Navigation.findNavController(_view)
                        .navigate(R.id.action_homeFragment_to_detailFragment2)
                }
            }
        }
    }

    private fun bindObserver() {
        viewModel.getCapsules()
        viewModel.capsulesLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is DataFetchResult.Progress -> {
                }
                is DataFetchResult.Failure -> {
                }
                is DataFetchResult.Success -> {
                }
            }
        })
        viewModel.capsulesPublishSubject.subscribe { data ->
            adapter.getAdapter().updateAllItems(data)
        }.isDisposed
    }
}