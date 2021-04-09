package com.learning.androidlearning.movemarker.kotlin.splash;

public interface SplashModel {

    void getCoreConfig(CallBack<GetCoreResponse> callBack);

    boolean isUserLoggedIn();

    String getLang();

    void updateLang(String lang);

    int getVersionCode();

    void callLoginApi(String name, String pasword, CallBack<GetCoreResponse> callBack);

    void saveStringByKey(String Key, String value);

}
