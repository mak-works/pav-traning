package com.learning.androidlearning.movemarker.kotlin.splash

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("todos")
    fun getUserData(): Call<List<UserData>>
}

