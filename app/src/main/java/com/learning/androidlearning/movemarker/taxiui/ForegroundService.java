package com.learning.androidlearning.movemarker.taxiui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.maps.ShowLocationActivity;

public class ForegroundService extends Service {
    private static final String ACTION_BROADCAST ="broadcast" ;
    private final IBinder myBinder = new LocalBoundService();
    public static final String CHANNEL_ID = "ForegroundServiceChannel";
    private final String TAG = ForegroundService.class.getSimpleName();
    private Notification notification;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    private double lattitude,longtitude;



    @Override
    public void onCreate() {
        super.onCreate();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                Log.d(TAG, "onLocationResult: "+locationResult.getLocations());
                super.onLocationResult(locationResult);
                getNewLocation(locationResult.getLastLocation());
            }
        };

        createLocationRequest();
        requestLocationUpdates();
       /* Intent broadCastIntent=new Intent();
        broadCastIntent.setAction(ShowLocationActivity.mBroadcastStringAction);
        broadCastIntent.putExtra("LONG",newLocation.getLatitude());
        broadCastIntent.putExtra("LATT",newLocation.getLongitude());
        sendBroadcast(broadCastIntent);*/

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input= intent.getStringExtra("inputExtra");
        Log.d(TAG, "onStartCommand: "+input);
        createNotificationChannel();
        return START_NOT_STICKY; }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }
    private void requestLocationUpdates() {
        try {
            Log.d(TAG, "requestLocationUpdates: ");
            fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                    locationCallback, Looper.myLooper());
            Log.d(TAG, "locationRequest: "+locationRequest);
        } catch (SecurityException unlikely) {
            Log.d(TAG, "requestLocationUpdates: catch");
        }
    }

    private void createLocationRequest() {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(100000);
        locationRequest.setFastestInterval(50000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }



    private void getNewLocation(Location lastLocation) {
        Log.d(TAG, "getNewLocation: "+lastLocation);


    }
    private void createNotificationChannel() {
        Log.d(TAG, "createNotificationChannel: ");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
            Intent notificationIntent = new Intent(this, LoginActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, notificationIntent, 0);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
            notification = notificationBuilder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText("New Foreground notification")
                    .setContentTitle("Foreground Service")
                    .setPriority(NotificationManager.IMPORTANCE_MIN)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .setContentIntent(pendingIntent) //intent
                    .build();

            Log.d(TAG, "notification: "+notification);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(1, notificationBuilder.build());
            startForeground(1, notification);
        }
    }

    public void updateNotification(String Text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
            Intent notificationIntent = new Intent(this, LoginActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, notificationIntent, 0);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
            Notification notification = notificationBuilder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText(Text)
                    .setContentTitle("Foreground Service")
                    .setPriority(NotificationManager.IMPORTANCE_MIN)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .setContentIntent(pendingIntent) //intent
                    .build();
            Log.d(TAG, "notification: " + notification);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(1, notificationBuilder.build());
        }
    }
    public class LocalBoundService extends Binder {
        public ForegroundService getService() {
            return ForegroundService.this;
        }
    }
}
