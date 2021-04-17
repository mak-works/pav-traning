package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

public interface SplashContract
{
    interface SplashView
    {
        fun showData(userData: List<UserData>);
        fun showfailure(errorThrowable: Throwable)
    }
    interface SplashPresenter
    {
        fun requestData();
    }
    interface SplashModel
    {
         fun getUserData(callBack:CallBack<List<UserData>>);
    }

}