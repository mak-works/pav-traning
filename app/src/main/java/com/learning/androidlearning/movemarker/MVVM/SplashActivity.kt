package com.learning.androidlearning.movemarker.MVVM

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.androidlearning.R

class SplashActivity : AppCompatActivity() {
    val TAG = "SplashActivity"
    var rvUserData: RecyclerView? = null
    var userDataAdapter: UserDataAdapter?=null
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        rvUserData = findViewById(R.id.rv_userdata)
        rvUserData?.layoutManager = LinearLayoutManager(this)
        setupViewModel()
        getUserData()
    }
    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    }
    private fun getUserData() {
        mainViewModel.getUsers().observe(this, Observer {
            when(it.status)
            {
                Status.SUCCESS->
                { it.data?.let { users -> renderList(users) } }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
    private fun renderList(users: List<UserData>) {
        userDataAdapter = UserDataAdapter(users,this)
        rvUserData?.addItemDecoration(
                DividerItemDecoration(
                        rvUserData?.context,
                        (rvUserData?.layoutManager as LinearLayoutManager).orientation)
        )
        rvUserData?.adapter = userDataAdapter
    }
}