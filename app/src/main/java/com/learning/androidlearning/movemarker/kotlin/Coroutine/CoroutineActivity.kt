package com.learning.androidlearning.movemarker.kotlin.Coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.androidlearning.R
import com.learning.androidlearning.movemarker.kotlin.MVVM.*

class CoroutineActivity : AppCompatActivity() {

    var TAG="CoroutineActivity"
    var rvUserData: RecyclerView? = null
    var apiUserAdapter: ApiUserAdapter?=null
    var userDataViewModel: ApiUserViewModel?=null
    var appController:AppController?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        rvUserData = findViewById(R.id.rv_userdata)
        rvUserData?.layoutManager = LinearLayoutManager(this)
        appController=AppController().appcontollerInstance
        setupViewModel()
        getUserData()
    }

    private fun setupViewModel() {
        userDataViewModel = ViewModelProviders.of(
                this,
                appController?.let
                { ViewModelFactory(it) })
                .get(ApiUserViewModel::class.java)
    }

    private fun getUserData() {
        Log.d(TAG, "setupViewModel: ")
        userDataViewModel?.getUsers()?.observe(this, Observer {
            when(it.status)
            {
                Status.SUCCESS->
                { it.data?.let {
                    users -> renderList(users) } }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<ApiUser>) {
        Log.d(TAG, "renderList: "+users)
        apiUserAdapter= ApiUserAdapter(users,this)
        rvUserData?.addItemDecoration(
                DividerItemDecoration(
                        rvUserData?.context,
                        (rvUserData?.layoutManager as LinearLayoutManager).orientation))
        rvUserData?.adapter = apiUserAdapter
    }
}