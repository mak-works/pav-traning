package com.learning.androidlearning.movemarker.taxiui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.learning.androidlearning.R;

public class ForegroundService extends Service {
    private final IBinder myBinder = new LocalBoundService();
    public static final String CHANNEL_ID = "ForegroundServiceChannel";
    private final String TAG = ForegroundService.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
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
    public void createNotificationChannel() {
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
            Notification notification = notificationBuilder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText("Foreground service enables")
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
    public Notification getActivityNotification(String Text)
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            ((NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(
                    new NotificationChannel("timer_notification","Timer Notification", NotificationManager.IMPORTANCE_HIGH));
        }
        PendingIntent contentIntent=PendingIntent.getActivity(this,
                0,new Intent(this,DashboardActivity.class),0);

        return new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle(Text)
                .setContentText(Text)
                .setOnlyAlertOnce(true) // so when data is updated don't make sound and alert in android 8.0+
                .setOngoing(true)
                .setContentIntent(contentIntent)
                .build();
    }
    public class LocalBoundService extends Binder {
        ForegroundService getService() {
            return ForegroundService.this;
        }
    }
}
