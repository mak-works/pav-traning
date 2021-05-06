package com.learning.androidlearning.movemarker.kotlin.Coroutine

import android.app.Application
import android.content.Context

class AppController():Application() {

    private var instance: AppController
    private var apiInterface: ApiInterface?=null

    init {
        instance=this
    }
    val appcontollerInstance:AppController
        get(){
                 if(instance==null)
                 {
                     instance=AppController()
                 }
            return instance
        }

    fun getApiInterface(): ApiInterface? {
            if (apiInterface == null) {
                apiInterface = ServiceBuilder.create()
            }
            return apiInterface
        }



    }
