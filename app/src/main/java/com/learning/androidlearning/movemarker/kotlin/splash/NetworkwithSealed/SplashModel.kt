package com.learning.androidlearning.movemarker.kotlin.splash.NetworkwithSealed
import retrofit2.Call
import retrofit2.Response

class SplashModel:SplashContract.SplashModel {
    val userdata=ServiceBuilder.create().getUserData()
    override fun getUserData(userData: Result<List<UserData>>) {
        val call = ServiceBuilder.create().getUserData()
        call.enqueue(object : retrofit2.Callback<List<UserData>> {
            override fun onResponse(call: Call<List<UserData>>, response: Response<List<UserData>>) {
                if (response.isSuccessful)
                {
                    UserResponse.Success(response.body()!!)
                } else {
                    UserResponse.ResponseFailure(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                UserResponse.ConnectionFailure(t)
            }
        });
    }
}