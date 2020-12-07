package com.learning.androidlearning.movemarker.taxiui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.taxiui.utils.ShiftOutDialog;

public class DashboardActivity extends AppCompatActivity {

    TextView tvStatistic,tvTrackmyTrip;
    ImageView imvProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tvStatistic=findViewById(R.id.tv_statistics);
        tvTrackmyTrip=findViewById(R.id.tv_track_my_trip);
        imvProfile=findViewById(R.id.imv_profile_db);
        tvStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShiftOutDialog shiftfOutDialog=new ShiftOutDialog(DashboardActivity.this);
                shiftfOutDialog.setCancelable(true);
                shiftfOutDialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttonbackground));
                shiftfOutDialog.show();

            }
        });

        tvTrackmyTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        imvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });



    }

}