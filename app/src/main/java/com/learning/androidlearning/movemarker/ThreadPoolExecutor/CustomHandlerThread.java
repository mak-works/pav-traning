package com.learning.androidlearning.movemarker.ThreadPoolExecutor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

public class CustomHandlerThread extends HandlerThread {

    private WeakReference<UiThreadCallback> mUiThreadCallback;

    public CustomHandlerThread(String name) {
        super(name, android.os.Process.THREAD_PRIORITY_BACKGROUND);
    }

    public void setUiThreadCallback(UiThreadCallback callback){
        this.mUiThreadCallback = new WeakReference<UiThreadCallback>(callback);
    }

    private class CustomHandler extends Handler
    {
        public CustomHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    }
}
