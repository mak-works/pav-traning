package com.learning.androidlearning.movemarker.taxiui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.taxiui.utils.ShiftOutDialog;
import com.learning.androidlearning.movemarker.taxiui.utils.Utils;

public class DashboardActivity extends AppCompatActivity {

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

        findViewById(R.id.tv_track_my_trip).setOnClickListener(v -> navigateProfile());

        findViewById(R.id.imv_profile_db).setOnClickListener(v -> navigateProfile());
    }
    private void navigateProfile(){
        Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

}