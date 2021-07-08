package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

interface SplashContract {
    interface SplashView {
        fun showData(userData: List<UserData>);
        fun showFailure(errorThrowable: Throwable)
    }

    interface SplashPresenter {
        fun requestData();
    }

    interface SplashModel {
        fun getUserData(callBack: CallBack<List<UserData>>);
    }
}