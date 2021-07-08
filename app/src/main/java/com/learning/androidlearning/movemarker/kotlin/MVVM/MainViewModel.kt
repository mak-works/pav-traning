package com.learning.androidlearning.movemarker.kotlin.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response

class MainViewModel():ViewModel() {
    private val users = MutableLiveData<Resource<List<UserData>>>()
    init {
        fetchUsers()
    }
    private fun fetchUsers() {
        val call=ServiceBuilder.create().getUserData()
        call.enqueue(object : retrofit2.Callback<List<UserData>> {

            override fun onResponse(call: Call<List<UserData>>, response: Response<List<UserData>>) {
                users.postValue(Resource.success(response.body()))
            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                users.postValue(Resource.error("Something Went Wrong", null))
            }

        });
    }
    fun getUsers(): LiveData<Resource<List<UserData>>> {
            return users
        }
    }