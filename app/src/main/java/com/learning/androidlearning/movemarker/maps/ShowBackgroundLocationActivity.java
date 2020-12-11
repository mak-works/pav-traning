package com.learning.androidlearning.movemarker.maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.taxiui.ForegroundService;
import com.learning.androidlearning.movemarker.taxiui.utils.MyAppConstants;

public class ShowBackgroundLocationActivity extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    private final String TAG = ShowBackgroundLocationActivity.class.getSimpleName();
    private TextView tvLongtitude,tvLattitude;
    private ForegroundService foregroundService;
    private Boolean mServiceBound = false;
    private BroadcastReceiver activityReceiver;
    private double lattitude,longtitude;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_location);
        tvLongtitude = findViewById(R.id.tv_lattitude);
        tvLattitude = findViewById(R.id.tv_longtitude);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getBackgroundLocationFromService();
        createLocationCallback();
        createLocationRequest();
        requestLocationUpdates();
    }
    private void getBackgroundLocationFromService() {
        Log.d(TAG, "getBackgroundLocationFromService: ");
        activityReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                lattitude=intent.getDoubleExtra("LATT",lattitude);
                longtitude=intent.getDoubleExtra("LONG",longtitude);
                tvLattitude.setText(String.valueOf(lattitude));
                tvLongtitude.setText(String.valueOf(longtitude));
            }
        };
        localBroadcastManager=LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyAppConstants.BROADCAST_STRING);
        localBroadcastManager.registerReceiver(activityReceiver, intentFilter);
    }
    private void createLocationCallback() {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                Log.d(TAG, "onLocationResult: "+locationResult.getLocations());
                super.onLocationResult(locationResult);
                sendBackgroundLocationToService(locationResult.getLastLocation());
            }
        };
    }
    private void createLocationRequest() {
        Log.d(TAG, "createLocationRequest: ");
        locationRequest = new LocationRequest();
        locationRequest.setInterval(100000);
        locationRequest.setFastestInterval(50000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }
    private void requestLocationUpdates() {
        try {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                    locationCallback, Looper.myLooper());
        } catch (SecurityException unlikely) {
        }
    }
    private void sendBackgroundLocationToService(Location lastLocation) {
        tvLattitude.setText(String.valueOf(lastLocation.getLatitude()));
        tvLongtitude.setText(String.valueOf(lastLocation.getLongitude()));
        foregroundService.updateNotification(String.valueOf(lastLocation.getLatitude())+String.valueOf(lastLocation.getLongitude()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        startBindService();
    }
    private void startBindService() {
        Log.d(TAG, "startbindservice: ");
        Intent intent = new Intent(this, ForegroundService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unBindService();
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
    private ServiceConnection mServiceConnection = new ServiceConnection() {

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
            mServiceConnection=null;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mServiceConnection=null;
    }
}