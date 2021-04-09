package com.learning.androidlearning.movemarker.kotlin.splash

import com.learning.androidlearning.movemarker.kotlin.splash.SplashContract.Presenter

class SplashPresenter internal constructor(private val model: SplashModel, private val view: SplashContract.View) : Presenter {

    override fun start() {
        /*model.getCoreConfig(object : CallBack<GetCoreResponse?>() {
            fun success(objects: GetCoreResponse) {
                *//*  if (objects.getDetail().getVersion_code() > model.getVersionCode()) *//*
                if (objects.getDetail().getVersion_code() > 21) {
                    view.showVersionUpgradeDialog(objects.getDetail().getVersion_name(), objects.getDetail().getIs_mandatory_update())
                } else {
                    view.apiCalled()
                }
            }

            fun responseFailure(objects: GetCoreResponse?) {
                if (objects == null) {
                    view.showMessage(Constants.ERROR_RESPONSE, "")
                } else {
                    view.showMessage(Constants.DIALOG_MESSAGE, objects.getMessage())
                }
            }

            fun connectionFailure(errorThrowable: Throwable?) {
                view.showMessage(Constants.ERROR_NETWORK, "")
            }
        })*/
    }

    override val isUserLoggedIn: Boolean
        get() = model.isUserLoggedIn()
    override val lang: String
        get() = model.getLang()

    override fun updateLang(lang: String?) {
        model.updateLang(lang)
    }

    override fun saveStringByKey(Key: String?, value: String?) {
        model.saveStringByKey(Key, value)
    }

    init {
        view.setPresenter(this)
    }
}