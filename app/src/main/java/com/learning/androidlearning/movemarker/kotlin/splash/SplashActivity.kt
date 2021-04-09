package com.learning.androidlearning.movemarker.kotlin.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ViewUtils
import com.learning.androidlearning.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashFragment: SplashFragment = SplashFragment.newInstance()
        /*SplashPresenter(SplashModelImp(),splashFragment)
        Viewutils.addFragmentToActivity(supportFragmentManager, splashFragment, R.id.lay_fr_container)*/
    }
}