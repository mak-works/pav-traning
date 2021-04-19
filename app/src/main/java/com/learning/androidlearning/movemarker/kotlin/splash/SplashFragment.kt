package com.learning.androidlearning.movemarker.kotlin.splash

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.transition.*
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.learning.androidlearning.R


public class SplashFragment: Fragment() ,SplashContract.View {
    private var presenter: SplashContract.Presenter? = null
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity?.let { AppController.isOnline(it) } == true)
        {
            if (presenter != null) {
                presenter!!.start()
            }
        }
        else {
            activity?.let { NetworkErrorActivity.startActivity(it) }
        }
    }

    fun nextGo() {
        presenter!!.saveStringByKey(SessionKeys.NEED_TO_SHOW_NOTIFICATION_BANNER, "1")
        if (!presenter!!.isUserLoggedIn) {
            activity?.let { LoginActivity.startActivity(it) }
        } else {
            activity?.let { BookActivity.startActivity(it) }
        }
        if (activity != null) {
            activity!!.finish()
        }
    }

    override fun showMessage(type: Int, message: String?) {
        var posText = getString(R.string.ok)
        val title = getString(R.string.info)
        var message=message;
        //SnackBar
        //SnackBar
        var positiveLis: CompactDialog.DialogListener? = null
        var isToast = false
        when (type) {
            Constants.DIALOG_MESSAGE -> isToast = false
            Constants.ERROR_RESPONSE,
            Constants.ERROR_NETWORK -> {
                isToast = false
                posText = getString(R.string.retry)
                message = getString(R.string.err_network)
                positiveLis = object : CompactDialog.DialogListener {
                    override fun onClick(dialog: DialogFragment?) {
                        dialog!!.dismiss()
                        presenter!!.start()
                    }
                }

            }
            else -> isToast = true
        }
        if (isToast) {
            ViewUtils.showToast(activity, message)
        } else {
            ViewUtils.showMaterialAlertDialog(activity, title, message, posText, null, positiveLis, null, true)
        }
        TODO("Not yet implemented")
    }

    override fun apiCalled() {
        val lang: String? = presenter!!.getLang
        if (TextUtils.isEmpty(lang)) {
           /* firebaseAnalyticsEvents.clickAction(AnalyticsConstants.ACTIONS.LANGUAGE,
                    AnalyticsConstants.Screen.SPLASH)*/
            mainLayout!!.visibility = View.VISIBLE
            val mainScene: Scene = Scene.getSceneForLayout(mainLayout, R.layout.view_infl_splash, context)
            val set = TransitionSet()
            val left = Slide(Gravity.START)
            val right = Slide(Gravity.END)
            left.addTarget(R.id.cv_eng)
            right.addTarget(R.id.cv_arabic)
            set.addTransition(left)
            set.addTransition(right)
            set.addTransition(ChangeBounds())
            set.setOrdering(TransitionSet.ORDERING_TOGETHER)
            set.setDuration(Constants.VIEW_ANIM_SPEED.toLong())
            TransitionManager.go(mainScene, set)
            val english: CardView = mainLayout!!.findViewById(R.id.cv_eng)
            english.setOnClickListener {
                AppController.getInstance().setLanguage(Constants.ENG)
                //update the launguage english
                presenter!!.updateLang(Constants.ENG)
               /* firebaseAnalyticsEvents.clickAction(AnalyticsConstants.ACTIONS.LANGUAGE,
                        AnalyticsConstants.ACTIONS.LANGUAGE_ENGLISH_ACTION)*/
                nextGo()
            }
            val arabic: CardView = mainLayout!!.findViewById(R.id.cv_arabic)
            arabic.setOnClickListener {
                AppController.getInstance().setLanguage(Constants.ARABIC)
                presenter!!.updateLang(Constants.ARABIC)
                //update the launguage arabic
                nextGo()
               /* firebaseAnalyticsEvents.clickAction(AnalyticsConstants.ACTIONS.LANGUAGE,
                        AnalyticsConstants.ACTIONS.LANGUAGE_ARABIC_ACTION)*/
            }
        } else {
            /*firebaseAnalyticsEvents.clickAction(lang,
                    AnalyticsConstants.ACTIONS.LANGUAGE_SELECTED)
            com.indipro.passenger.AppController.getInstance().setLanguage(lang)*/
            nextGo()
        }
    }

    override fun showVersionUpgradeDialog(versionName: String?, showVersionUpgradeDialog: Int) {
       /* firebaseAnalyticsEvents.clickAction(AnalyticsConstants.ACTIONS.UPDATE_POPUP,
                AnalyticsConstants.Screen.SPLASH)*/
        ViewUtils.showMaterialAlertDialog(activity, getString(R.string.dia_version_title), getString(R.string.dia_version_description, versionName),
                getString(R.string.update),
                if (showVersionUpgradeDialog == 1) null else getString(R.string.later),
                object : CompactDialog.DialogListener {
                    override fun onClick(dialog: DialogFragment?) {
                        /*firebaseAnalyticsEvents.clickAction(AnalyticsConstants.ACTIONS.VERSION_UPDATE_CLICK,
                        AnalyticsConstants.Screen.SPLASH)*/
                        dialog!!.dismiss()
                        val appPackageName = activity!!.packageName // getPackageName() from Context or Activity object
                        try {
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
                        } catch (anfe: ActivityNotFoundException) {
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=$appPackageName")))
                        }
                        activity!!.finish()
                        apiCalled()
                    }

                }, object : CompactDialog.DialogListener {
            override fun onClick(dialog: DialogFragment?) {
                /* firebaseAnalyticsEvents.clickAction(AnalyticsConstants.ACTIONS.VERSION_UPDATE_CLOSE,
                        AnalyticsConstants.Screen.SPLASH)*/
                dialog!!.dismiss()
                if (showVersionUpgradeDialog == 1) {
                    activity!!.finish()
                } else {
                    apiCalled()
                }
            }


        }, false)
    }

    override fun setPresenter(presenter: SplashContract.Presenter?) {
        this.presenter = presenter
    }
}


