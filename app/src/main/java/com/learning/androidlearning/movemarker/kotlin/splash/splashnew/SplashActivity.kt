package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.androidlearning.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val request = ServiceBuilder.create().getUserData()
        val rvUserData: RecyclerView = findViewById(R.id.rv_userdata)
        lateinit var userDataAdapter: UserDataAdapter
        val TAG: String = "SplashActivity"

        request.enqueue(object : retrofit2.Callback<List<UserData>> {
            override fun onResponse(call: retrofit2.Call<List<UserData>>?, response: retrofit2.Response<List<UserData>>?) {
                if (response!!.isSuccessful) {
                    if(response?.body() != null)
                    {
                        Log.d(TAG, "onResponse: ")
                        val layoutManager = LinearLayoutManager(applicationContext)
                        rvUserData.layoutManager = layoutManager
                        userDataAdapter = UserDataAdapter(response.body()!!)
                        rvUserData.adapter = userDataAdapter
                    }

                }
            }

            override fun onFailure(call: retrofit2.Call<List<UserData>>, t: Throwable) {
                Log.d(TAG, "onFailure: "+t.message)
                Toast.makeText( this@SplashActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        });
    }
}