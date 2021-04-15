package com.learning.androidlearning.movemarker.kotlin.splash

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.androidlearning.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)


    }

companion object
{
    fun startActivity(activity: Activity):Intent
    {
        val intent=Intent(activity,LoginActivity::class.java)
        return intent
    }

}





}