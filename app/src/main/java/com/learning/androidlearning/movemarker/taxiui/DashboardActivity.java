package com.learning.androidlearning.movemarker.taxiui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.taxiui.utils.ShiftOutDialog;
import com.learning.androidlearning.movemarker.taxiui.utils.Utils;

public class DashboardActivity extends AppCompatActivity {
    private final String TAG = DashboardActivity.class.getSimpleName();
    private ForegroundService foregroundService;
    private Boolean mServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        findViewById(R.id.tv_statistics).setOnClickListener(v -> {
            ShiftOutDialog shiftOutDialog = new ShiftOutDialog(DashboardActivity.this);
            shiftOutDialog.setCancelable(true);
            shiftOutDialog.getWindow().setBackgroundDrawable(Utils.getDrawableRes(getResources()));
            shiftOutDialog.show();

        });
        findViewById(R.id.tv_track_my_trip).setOnClickListener(v ->
                {
                    if(foregroundService!=null)
                    {
                        foregroundService.updateNotification("Forground notification updated");
                    }
                });
        findViewById(R.id.imv_profile_db).setOnClickListener(v -> navigateProfile());
    }

    @Override
    protected void onStart() {
        super.onStart();
        startBindService();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unBindService();
    }
    private void  startBindService() {
        Log.d(TAG, "startbindservice: ");
        Intent intent = new Intent(this, ForegroundService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        super.onStart();
    }
    private void unBindService() {
        if(mServiceConnection!=null)
        {
            if (mServiceBound) {
                unbindService(mServiceConnection);
                mServiceBound = false;
            }
        }
    }
    private void navigateProfile() {
        Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
        startActivity(intent);
        if(foregroundService!=null)
        {
            foregroundService.updateNotification("Forground notification updated");
        }
    }
    private final ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: ");
            ForegroundService.LocalBoundService myBinder = (ForegroundService.LocalBoundService) service;
            foregroundService = myBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
            mServiceBound = false;
            mServiceBound=null;
        }
    };
}