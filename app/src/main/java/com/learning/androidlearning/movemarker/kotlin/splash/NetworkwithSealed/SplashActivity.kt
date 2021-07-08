package com.learning.androidlearning.movemarker.kotlin.splash.NetworkwithSealed

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.androidlearning.R

class SplashActivity : AppCompatActivity(),SplashContract.SplashView {
    val TAG = "SplashActivity"
    var splashPresenter: SplashPresenter? = null
    var rvUserData: RecyclerView? = null
    var userDataAdapter:UserDataAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        rvUserData = findViewById(R.id.rv_userdata)
        rvUserData?.layoutManager = LinearLayoutManager(this)
        splashPresenter= SplashPresenter(this,SplashModel())
        splashPresenter?.requestData()
    }

    override fun showData(userData: List<UserData>) {
        userDataAdapter = UserDataAdapter(userData, this)
        rvUserData?.adapter = userDataAdapter
    }

    override fun showResponseFailure(userData: List<UserData>) {
        userDataAdapter = UserDataAdapter(userData, this)
        rvUserData?.adapter = userDataAdapter
    }

    override fun showConnectionFailure(errorThrowable: Throwable) {
        val toast = Toast.makeText(applicationContext, errorThrowable.message, Toast.LENGTH_SHORT)
        toast.show()
    }
}