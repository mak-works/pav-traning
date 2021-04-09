package com.learning.androidlearning.movemarker.kotlin.splash

import android.app.Activity
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.ViewUtils
import com.learning.androidlearning.R
import com.learning.androidlearning.movemarker.kotlin.splash.Viewutils.Companion.addFragmentToActivity

class Splash : AppCompatActivity() {
    companion object {
        /**
         * Start the splash
         *
         * @param conActivity instance
         */
        fun startActivity(conActivity: Activity) {
            val `in` = Intent(conActivity, SplashActivity::class.java)
            `in`.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            conActivity.startActivity(`in`)
        }

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        /*val fragment = SplashFragment.newInstance()
        SplashPresenter(SplashModelImp(this),fragment)
        Viewutils.addFragmentToActivity(supportFragmentManager, fragment, R.id.lay_fr_container)
        AppEventsLogger.newLogger(this).logEvent("User Open")
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager?.cancelAll()
        com.indipro.passenger.AppController.getInstance().getAnalyticsEvents().screenEvent(AnalyticsConstants.Screen.SPLASH)
        Logger.e("haskeysms** ", AppSignatureHelper(this).getAppSignatures().toString())*/
    }

    override fun attachBaseContext(base: Context) {
        //For video view leak issue
        /*super.attachBaseContext(AudioServiceActivityLeak.preventLeakOf(base))*/
    }
}