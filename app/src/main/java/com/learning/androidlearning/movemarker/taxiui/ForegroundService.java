package com.learning.androidlearning.movemarker.taxiui;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.maps.ShowBackgroundLocationActivity;
import com.learning.androidlearning.movemarker.taxiui.utils.MyAppConstants;

public class ForegroundService extends Service {
    private final IBinder myBinder = new LocalBoundService();
    private final String TAG = ForegroundService.class.getSimpleName();
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        createLocationCallback();
        createLocationRequest();
        requestLocationUpdates();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        GenerateUpdteNotification("New Foreground Notification");
        return START_NOT_STICKY; }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        removeLocationUpdates();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }
    private void createLocationCallback() {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                Log.d(TAG, "onLocationResult: "+locationResult.getLocations());
                super.onLocationResult(locationResult);
                sendLocationToActivity(locationResult.getLastLocation().getLatitude(),locationResult.getLastLocation().getLongitude());
    }}; }
    private void createLocationRequest() {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(100000);
        locationRequest.setFastestInterval(50000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }
    @SuppressLint("MissingPermission")
    private void requestLocationUpdates() {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                    locationCallback, Looper.myLooper());
    }
    private void removeLocationUpdates() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

    private void sendLocationToActivity(double latitude,double longtitude) {
        Intent broadCastIntent=new Intent();
        broadCastIntent.setAction(MyAppConstants.BROADCAST_STRING);
        broadCastIntent.putExtra("LAT",latitude);
        broadCastIntent.putExtra("LONG",longtitude);
        Log.d(TAG, "latitude: "+latitude);
        Log.d(TAG, "longtitude: "+longtitude);
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadCastIntent);
    }

    public void GenerateUpdteNotification(String Text) {
        Log.d(TAG, "updateNotification: ");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    MyAppConstants.CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
            Intent notificationIntent = new Intent(this, ShowBackgroundLocationActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, notificationIntent, 0);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, MyAppConstants.CHANNEL_ID);
            Notification notification = notificationBuilder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText(Text)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                   /* .addAction(R.mipmap.ic_launcher,"Open",pendingIntent)*/
                    .addAction(R.mipmap.ic_launcher,"Open Notification", pendingIntent)
                    .setContentTitle("Foreground Service")
                    .setPriority(NotificationManager.IMPORTANCE_HIGH)
                    .setFullScreenIntent(pendingIntent,true)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .setColor(Color.BLACK)
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
