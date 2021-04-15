package com.learning.androidlearning.movemarker.kotlin.splash

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

public class AppController:Application() {

    var newLanguage: String?=null
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object
    {

        fun isOnline(ctx: Context): Boolean {
            val connectivity = ctx.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivity != null) {
                val info = connectivity.allNetworkInfo
                if (info != null) {
                    for (element in info) {
                        if (element.state == NetworkInfo.State.CONNECTED) {
                            return true
                        }
                    }
                }
            }
            return false
        }

        lateinit var INSTANCE: AppController
        fun getInstance(): AppController {
            return INSTANCE
        }




    }
    fun setLanguage(language: String) {
        newLanguage = language
    }



}