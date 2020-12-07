package com.learning.androidlearning.movemarker.taxiui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.taxiui.utils.ShiftOutDialog;

public class LoginActivity extends AppCompatActivity {
    EditText edMobileNo, edDriverId, edPassword;
    Button btn_sign_in;
    String mobilno,driverId,password;
    String TAG=LoginActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edMobileNo=findViewById(R.id.edMobileno);
        edDriverId=findViewById(R.id.ed_driver_id);
        edPassword=findViewById(R.id.ed_password);
        btn_sign_in=findViewById(R.id.btn_sign_in);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobilno = edMobileNo.getText().toString();
                driverId = edDriverId.getText().toString();
                password = edPassword.getText().toString();
                Log.d(TAG, "onClick: "+mobilno);
                Log.d(TAG, "onClick: "+driverId);
                Log.d(TAG, "onClick: "+password);
                
                if (mobilno.matches("")) {
                    Log.d(TAG, "onClick: -----------------");
                    ShiftOutDialog shiftOutDialog=new ShiftOutDialog(LoginActivity.this);
                    shiftOutDialog.setCancelable(true);
                    shiftOutDialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttonbackground));
                    shiftOutDialog.show();
                    shiftOutDialog.setMessage("All fields required");
                }
                else if(driverId.matches(""))
                {
                    ShiftOutDialog shiftOutDialog=new ShiftOutDialog(LoginActivity.this);
                    shiftOutDialog.setCancelable(true);
                    shiftOutDialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttonbackground));
                    shiftOutDialog.show();
                    shiftOutDialog.setMessage("All fields required");
                }
                else if(password.matches(""))
                {
                    ShiftOutDialog shiftOutDialog=new ShiftOutDialog(LoginActivity.this);
                    shiftOutDialog.setCancelable(true);
                    shiftOutDialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttonbackground));
                    shiftOutDialog.show();
                    shiftOutDialog.setMessage("All fields required");
                }
                else
                {
                    Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }

            }
        });


    }
}
