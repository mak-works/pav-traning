package com.learning.androidlearning.movemarker.taxiui.utils;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends Application {
    private final String TAG=MyApplication.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        LeakCanary.install(this);
    }
}
