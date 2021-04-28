package com.learning.androidlearning.movemarker.MVVM

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    fun getUserData(): Call<List<UserData>>
}