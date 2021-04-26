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
    var layoutManager:LinearLayoutManager?=null
    var userDataAdapter:UserDataAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        layoutManager = LinearLayoutManager(this@SplashActivity)
        rvUserData = findViewById(R.id.rv_userdata)
        splashPresenter= SplashPresenter(this@SplashActivity,SplashModel())
        splashPresenter?.requestData()
    }

    override fun showData(userData: List<UserData>) {
        rvUserData?.layoutManager = layoutManager
        userDataAdapter = UserDataAdapter(userData, this@SplashActivity)
        rvUserData?.adapter = userDataAdapter
    }

    override fun showResponseFailure(userData: List<UserData>) {
        userDataAdapter = UserDataAdapter(userData, this@SplashActivity)
        rvUserData?.adapter = userDataAdapter
    }

    override fun showConnectionFailure(errorThrowable: Throwable) {
        val toast = Toast.makeText(applicationContext, errorThrowable.message, Toast.LENGTH_SHORT)
        toast.show()
    }

}