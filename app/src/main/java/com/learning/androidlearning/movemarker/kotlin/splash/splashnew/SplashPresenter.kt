package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

class SplashPresenter(private var view: SplashContract.SplashView, private var model: SplashModel) : SplashContract.SplashPresenter {

    override fun requestData() {
        model.getUserData(object : CallBack<List<UserData>> {
            override fun success(objects: List<UserData>) {
                TODO("Not yet implemented")
            }

            override fun responseFailure(objects: List<UserData>) {
                TODO("Not yet implemented")
            }

            override fun connectionFailure(errorThrowable: Throwable?) {
                TODO("Not yet implemented")
            }


        });
    }
}