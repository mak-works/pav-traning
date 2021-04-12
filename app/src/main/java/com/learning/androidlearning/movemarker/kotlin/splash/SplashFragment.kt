package com.learning.androidlearning.movemarker.kotlin.splash

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.learning.androidlearning.R

public class SplashFragment: Fragment() ,SplashContract.View {
    private val presenter: SplashContract.Presenter? = null
    private var mainLayout: FrameLayout? = null

   /* private val firebaseAnalyticsEvents: FirebaseAnalyticsEvents? = null*/

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainLayout = view.findViewById(R.id.lay_fr_bottom)
        val splashRootLay = view.findViewById<FrameLayout>(R.id.ll_splash)
        TransitionManager.beginDelayedTransition(splashRootLay)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity!!.window.statusBarColor = resources.getColor(R.color.black, activity!!.theme)
        }
    }

   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        val activity: Activity? = activity
        activity?.finish()
        super.onActivityCreated(savedInstanceState)
        if (AppController.isOnline(())) {
            if (presenter != null) {
                presenter.start()
            }
        } else {
            NetworkErrorActivity.startActivity()
        }
    }
*/
    /*fun nextGo() {
        presenter!!.saveStringByKey(SessionKeys.NEED_TO_SHOW_NOTIFICATION_BANNER, "1")
        if (!presenter.isUserLoggedIn()) {
            LoginActivity.startActivity(activity)
        } else {
            BookActivity.startActivity(activity)
        }
        if (activity != null) {
            activity!!.finish()
        }
    }*/



    override fun showMessage(type: Int, message: String?) {
        TODO("Not yet implemented")
    }

    override fun apiCalled() {
        TODO("Not yet implemented")
    }

    override fun showVersionUpgradeDialog(versionName: String?, isMandatory: Int) {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: SplashContract.Presenter?) {
        TODO("Not yet implemented")
    }
}