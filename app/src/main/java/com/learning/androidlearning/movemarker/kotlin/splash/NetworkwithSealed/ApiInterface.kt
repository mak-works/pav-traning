package com.learning.androidlearning.movemarker.kotlin.splash.NetworkwithSealed

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
   @GET("todos")
   fun getUserData(): Call<List<UserData>>
}

