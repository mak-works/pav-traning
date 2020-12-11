package com.learning.androidlearning.movemarker.taxiui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
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
    private Notification notification;
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
        createNotificationChannel();
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
                getBackgroundLocation(locationResult.getLastLocation());
    }}; }
    private void createLocationRequest() {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(100000);
        locationRequest.setFastestInterval(50000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
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
    private void removeLocationUpdates() {
        try {
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        } catch (SecurityException unlikely) {
        }
    }
    private void getBackgroundLocation(Location lastLocation) {
        sendLocationtoActivity(lastLocation.getLatitude(),lastLocation.getLongitude());
    }
    private void sendLocationtoActivity(double lattitude,double longtitude) {
        Intent broadCastIntent=new Intent();
        broadCastIntent.setAction(MyAppConstants.BROADCAST_STRING);
        broadCastIntent.putExtra("LATT",lattitude);
        broadCastIntent.putExtra("LONG",longtitude);
        Log.d(TAG, "lattitude: "+lattitude);
        Log.d(TAG, "longtitude: "+longtitude);
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadCastIntent);
    }
    private void createNotificationChannel() {
        Log.d(TAG, "createNotificationChannel: ------");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    MyAppConstants.CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
            Intent notificationIntent = new Intent(this, LoginActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, notificationIntent, 0);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, MyAppConstants.CHANNEL_ID);
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
        Log.d(TAG, "updateNotification: ");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    MyAppConstants.CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
            Intent notificationIntent = new Intent(this, LoginActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, notificationIntent, 0);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, MyAppConstants.CHANNEL_ID);
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
