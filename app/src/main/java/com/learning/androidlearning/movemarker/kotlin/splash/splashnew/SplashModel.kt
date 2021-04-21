package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class SplashModel() : SplashContract.SplashModel {

    override fun getUserData(callBack: CallBack<List<UserData>>) {
        val call = ServiceBuilder.create().getUserData()
        call.enqueue(object : retrofit2.Callback<List<UserData>> {
            override fun onResponse(call: Call<List<UserData>>, response: Response<List<UserData>>) {
                if (response.isSuccessful) {
                    callBack.success(response.body()!!)
                } else {
                    callBack.responseFailure(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                callBack.connectionFailure(t)
            }
        });
    }
}