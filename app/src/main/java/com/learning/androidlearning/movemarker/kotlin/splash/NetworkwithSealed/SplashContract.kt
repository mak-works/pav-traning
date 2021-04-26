package com.learning.androidlearning.movemarker.kotlin.splash.NetworkwithSealed

interface SplashContract {
    interface SplashView {
        fun showData(userData: List<UserData>);
        fun showResponseFailure(userData: List<UserData>)
        fun showConnectionFailure(errorThrowable: Throwable)
    }
    interface SplashPresenter {
        fun requestData();
    }
    interface SplashModel {
        fun getUserData(userData: Result<List<UserData>>);
    }
}