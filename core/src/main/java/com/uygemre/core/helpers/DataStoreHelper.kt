package com.uygemre.core.helpers

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.PreferencesProto
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException

// Created by Emre UYGUN on 12.12.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

class DataStoreHelper(val context: Context) {

    private val Context.dataStore: DataStore<Preferences>? by preferencesDataStore(name = "baseDataStore")

    suspend fun <T> push(key: Preferences.Key<T>, value: T) {
        context.dataStore?.edit { preferences: MutablePreferences ->
            preferences[key] = value
        }
    }

    suspend fun <T> pull(key: Preferences.Key<T>, defaultValue: T): Flow<T>? {
        return context.dataStore?.data?.mapNotNull { value: Preferences ->
            value[key] ?: defaultValue
        }
    }

    suspend fun <T> remove(key: Preferences.Key<T>) {
        context.dataStore?.edit {
            it.remove(key)
        }
    }

    suspend fun clearAll() {
        context.dataStore?.edit {
            it.clear()
        }
    }

//    suspend fun push(key: Preferences.Key<String>, value: String) {
//        context.dataStore.edit { preferences ->
//            preferences[key] = value
//        }
//    }
//
//    suspend fun push(key: Preferences.Key<Int>, value: Int) {
//        context.dataStore.edit { preferences ->
//            preferences[key] = value
//        }
//    }
//
//    suspend fun push(key: Preferences.Key<Boolean>, value: Boolean) {
//        context.dataStore.edit { preferences ->
//            preferences[key] = value
//        }
//    }
//
//    suspend fun push(key: Preferences.Key<Double>, value: Double) {
//        context.dataStore.edit { preferences ->
//            preferences[key] = value
//        }
//    }
//
//    suspend fun push(key: Preferences.Key<Float>, value: Float) {
//        context.dataStore.edit { preferences ->
//            preferences[key] = value
//        }
//    }
//
//    suspend fun push(key: Preferences.Key<Long>, value: Long) {
//        context.dataStore.edit { preferences ->
//            preferences[key] = value
//        }
//    }
//
//    suspend fun push(
//        key: Preferences.Key<PreferencesProto.StringSet>,
//        value: PreferencesProto.StringSet
//    ) {
//        context.dataStore.edit { preferences ->
//            preferences[key] = value
//        }
//    }
//
//    suspend fun pull(key: Preferences.Key<String>, defaultValue: String): Flow<String> {
//        return context.dataStore.data.mapNotNull { value: Preferences ->
//            value[key] ?: defaultValue
//        }
//    }
//
//    suspend fun pull(key: Preferences.Key<Int>, defaultValue: Int): Flow<Int> {
//        return context.dataStore.data.mapNotNull { value: Preferences ->
//            value[key] ?: defaultValue
//        }
//    }
//
//    suspend fun pull(key: Preferences.Key<Boolean>, defaultValue: Boolean): Flow<Boolean> {
//        return context.dataStore.data.mapNotNull { value: Preferences ->
//            value[key] ?: defaultValue
//        }
//    }
//
//    suspend fun pull(key: Preferences.Key<Double>, defaultValue: Double): Flow<Double> {
//        return context.dataStore.data.mapNotNull { value: Preferences ->
//            value[key] ?: defaultValue
//        }
//    }
//
//    suspend fun pull(key: Preferences.Key<Float>, defaultValue: Float): Flow<Float> {
//        return context.dataStore.data.mapNotNull { value: Preferences ->
//            value[key] ?: defaultValue
//        }
//    }
//
//    suspend fun pull(key: Preferences.Key<Long>, defaultValue: Long): Flow<Long> {
//        return context.dataStore.data.mapNotNull { value: Preferences ->
//            value[key] ?: defaultValue
//        }
//    }
//
//    suspend fun pull(
//        key: Preferences.Key<PreferencesProto.StringSet>,
//        defaultValue: PreferencesProto.StringSet
//    ): Flow<PreferencesProto.StringSet> {
//        return context.dataStore.data.mapNotNull { value: Preferences ->
//            value[key] ?: defaultValue
//        }
//    }
}