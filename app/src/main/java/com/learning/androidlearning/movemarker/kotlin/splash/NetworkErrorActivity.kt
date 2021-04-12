package com.learning.androidlearning.movemarker.kotlin.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.androidlearning.R

class NetworkErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_error)



    }
    companion object
    {
        fun startActivity(activity: Activity) {

        }
    }
}