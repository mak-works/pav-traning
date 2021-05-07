package com.learning.androidlearning.movemarker.kotlin.Coroutine

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.learning.androidlearning.movemarker.kotlin.MVVM.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class ApiUserViewModel(private var appController: AppController):AndroidViewModel(appController) {
   private val users = MutableLiveData<Resource<List<ApiUser>>>()
   private val TAG="ApiUserViewModel"
   private var apiInterface:ApiInterface?=null

   init {
      fetchData()
   }

   private fun fetchData()
   {
      viewModelScope.launch {
         try {
               coroutineScope {
                   apiInterface=appController.appcontollerInstance.getApiInterface()
                   val userDataDeferred=async { apiInterface?.getUsers() }
                   val moreUserDataDeferred=async {apiInterface?.getMoreUsers() }

                   val userData=userDataDeferred.await()
                   val moreUserData=moreUserDataDeferred.await()

                   val allUserData=mutableListOf<ApiUser>()
                   userData?.let { allUserData.addAll(it) }
                   moreUserData?.let { allUserData.addAll(it) }

                  users.postValue(Resource.success(allUserData))
                }

         } catch (e: Exception) {
            users.postValue(Resource.error("Something Went Wrong", null))
         }
      }
   }

   fun getUsers(): LiveData<Resource<List<ApiUser>>> {
      Log.d(TAG, "getUsers: ")
      return users
   }
}