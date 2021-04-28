package com.learning.androidlearning.movemarker.MVVM

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ServiceBuilder {
    companion object {
        var BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun create(): ApiService {
            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}