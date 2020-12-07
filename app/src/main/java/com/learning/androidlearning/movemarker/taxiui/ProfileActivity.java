package com.learning.androidlearning.movemarker.taxiui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.taxiui.utils.ShiftOutDialog;
import com.learning.androidlearning.movemarker.taxiui.utils.Utils;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilenew);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShiftOutDialog shiftOutDialog = new ShiftOutDialog(ProfileActivity.this);
                shiftOutDialog.setCancelable(true);
                shiftOutDialog.getWindow().setBackgroundDrawable(Utils.getDrawableRes(getResources()));
                shiftOutDialog.show();
                shiftOutDialog.setMessage("You have clicked save");
            }
        });
        findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShiftOutDialog shiftOutDialog = new ShiftOutDialog(ProfileActivity.this);
                shiftOutDialog.setCancelable(true);
                shiftOutDialog.getWindow().setBackgroundDrawable(Utils.getDrawableRes(getResources()));
                shiftOutDialog.show();
                shiftOutDialog.setMessage("You have clicked logout");
            }
        });
    }
}