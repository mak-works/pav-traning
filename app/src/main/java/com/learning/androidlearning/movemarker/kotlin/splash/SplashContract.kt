package com.learning.androidlearning.movemarker.kotlin.splash

/**
 * Created by HP2 on 4/1/2018.
 */
interface SplashContract {
    interface View : BaseView<Presenter?> {
        fun showMessage(type: Int, message: String?)
        fun apiCalled()
        fun showVersionUpgradeDialog(versionName: String?, isMandatory: Int)
    }

    interface Presenter : BasePresenter {
        val isUserLoggedIn: Boolean
        val getLang: String?
        fun updateLang(lang: String?)
        fun saveStringByKey(Key: String?, value: String?)
    }


}