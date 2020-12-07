package com.learning.androidlearning.movemarker.taxiui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.taxiui.utils.ShiftOutDialog;
import com.learning.androidlearning.movemarker.taxiui.utils.Utils;

public class LoginActivity extends AppCompatActivity {
    private final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edMobileNo = findViewById(R.id.edMobileno);
        EditText edDriverId = findViewById(R.id.ed_driver_id);
        EditText edPassword = findViewById(R.id.ed_password);
        findViewById(R.id.btn_sign_in).setOnClickListener(v -> {
            String mobileNo = edMobileNo.getText().toString();
            String driverId = edDriverId.getText().toString();
            String password = edPassword.getText().toString();
            if (mobileNo.matches("")) {
                Log.d(TAG, "onClick: -----------------");
                showMessageAlert();
            } else if (driverId.matches("")) {
                showMessageAlert();
            } else if (password.matches("")) {
                showMessageAlert();
            } else {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showMessageAlert() {
        ShiftOutDialog shiftOutDialog = new ShiftOutDialog(LoginActivity.this);
        shiftOutDialog.setCancelable(true);
        shiftOutDialog.getWindow().setBackgroundDrawable(Utils.getDrawableRes(getResources()));
        shiftOutDialog.show();
        shiftOutDialog.setMessage("All fields required");
    }
}
