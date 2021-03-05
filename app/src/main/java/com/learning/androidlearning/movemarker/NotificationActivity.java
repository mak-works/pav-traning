package com.learning.androidlearning.movemarker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RemoteViews;

import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.maps.ShowBackgroundLocationActivity;
import com.learning.androidlearning.movemarker.taxiui.ForegroundService;
import com.learning.androidlearning.movemarker.taxiui.utils.MyAppConstants;

import java.util.concurrent.TimeUnit;

import static com.learning.androidlearning.movemarker.taxiui.utils.MyAppConstants.CHANNEL_ID;

public class NotificationActivity extends AppCompatActivity {

    MyCountDownTimer myCountDownTimer;
    private ForegroundService foregroundService;
    private Boolean mServiceBound = false;
    Long progress;
    String minValOne,minValTen,secValOne,secValTen;
    private Ringtone ringtone;
    private RemoteViews mRemoteViews;
    NotificationManager mNotificationManager;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        linearLayout=findViewById(R.id.linearlayout);
        mRemoteViews = new RemoteViews(getPackageName(), R.layout.notification_layout_new);
        Uri notificationuri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone = RingtoneManager.getRingtone(getApplicationContext(), notificationuri);
        if(ringtone!=null)
        {
            ringtone.play();
        }
        myCountDownTimer = new MyCountDownTimer(120000, 1000);
        myCountDownTimer.start();

    }
    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            progress=millisUntilFinished/1000;

            int min = (int) ((int) TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % TimeUnit.HOURS.toMinutes(1));
            int sec = (int) ((int) TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % TimeUnit.MINUTES.toSeconds(1));

            minValOne= String.valueOf((min / 10) % 6);
            minValTen=String.valueOf(min % 10);
            secValOne=String.valueOf((sec / 10) % 6);
            secValTen=String.valueOf(sec % 10);
            if(min==0&&sec<11)
            {
                mRemoteViews.setInt(R.id.linearlayout, "setBackgroundColor",getResources().getColor(R.color.colorRed));
            }

            GenerateUpdteNotification(minValOne,minValTen,secValOne,secValTen);
        }

        @Override
        public void onFinish() {
            ringtone.stop();
            mNotificationManager.cancel(1);
        }
    }
    private void GenerateUpdteNotification(String minValOne,String minValTen,String secValOne,String secValTen) {


        mRemoteViews.setTextViewText(R.id.min_one,minValOne);
        mRemoteViews.setTextViewText(R.id.min_ten,minValTen);
        mRemoteViews.setTextViewText(R.id.sec_one,secValOne);
        mRemoteViews.setTextViewText(R.id.sec_ten,secValTen);


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(getString(R.string.app_name))
                .setAutoCancel(true)
                .setOngoing(true)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContent(mRemoteViews);

        mNotificationManager.notify(1, mBuilder.build());
    }
}


