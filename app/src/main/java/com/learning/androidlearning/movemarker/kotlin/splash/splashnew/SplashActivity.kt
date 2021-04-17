package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.androidlearning.R
import com.learning.androidlearning.movemarker.kotlin.splash.LoginActivity

class SplashActivity : AppCompatActivity(),SplashContract.SplashView {
    val TAG = "SplashActivity"

    var presenter: SplashContract.SplashPresenter? = null
    var rvUserData: RecyclerView? = null
    val layoutManager = LinearLayoutManager(this@SplashActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val request = ServiceBuilder.create().getUserData()
        rvUserData= findViewById(R.id.rv_userdata)

        presenter=SplashPresenter(this, SplashModel())
        presenter?.let { it.requestData() }
    }

    override fun showData(userData: List<UserData>) {
        rvUserData!!.layoutManager = layoutManager
        val userDataAdapter = UserDataAdapter(userData)
        val map: Map<Int, String> = userData.associate { Pair(it.id, it.title) }
        rvUserData!!.adapter = userDataAdapter
    }

    override fun showfailure(errorThrowable: Throwable) {
        val Toast=Toast.makeText(applicationContext,errorThrowable.message,Toast.LENGTH_SHORT)
        Toast.show()
    }
}