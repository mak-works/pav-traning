package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ServiceBuilder {
    companion object {
        var BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun create(): ApiInterface {
            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}