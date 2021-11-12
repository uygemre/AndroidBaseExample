package com.uygemre.core.extension

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit

// Created by Emre UYGUN on 10.11.2021
// Copyriht © Demiroren Teknoloji. All rights reserved.

fun <T> Context.openActivity(it: Class<T>, bundle: Bundle) {
    val intent = Intent(this, it)
    intent.putExtras(bundle)
    startActivity(intent)
}

fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun FragmentActivity.replaceFragment(
    fragment: Fragment,
    containerId: Int
) {
    this.supportFragmentManager
        .beginTransaction()
        .replace(containerId, fragment)
        .commit()
}

fun AppCompatActivity.replaceFragment(
    fragment: Fragment,
    containerId: Int
) {
    supportFragmentManager.commit {
        setReorderingAllowed(true)
        replace(containerId, fragment)
    }
}
