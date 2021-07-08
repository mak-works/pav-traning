package com.learning.androidlearning.movemarker.kotlin.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.androidlearning.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)
        val fragment = SplashFragment.newInstance()
    }
}