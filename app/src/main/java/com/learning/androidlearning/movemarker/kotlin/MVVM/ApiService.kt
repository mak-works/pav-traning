package com.learning.androidlearning.movemarker.kotlin.MVVM

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    fun getUserData(): Call<List<UserData>>
}