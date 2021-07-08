package com.learning.androidlearning.movemarker.kotlin.Coroutine

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val appController: AppController): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ApiUserViewModel::class.java)) {
            return ApiUserViewModel(appController) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
