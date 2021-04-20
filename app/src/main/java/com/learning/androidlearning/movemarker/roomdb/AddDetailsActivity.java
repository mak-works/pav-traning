package com.learning.androidlearning.movemarker.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.roomdbnew.RoomActivity;

public class AddDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDetails();
            }
        });

        findViewById(R.id.btn_viewdetails).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddDetailsActivity.this, RoomActivity.class);
                startActivity(intent);
            }
        });
    }
    private void addDetails() {
        EditText edMobileNo = findViewById(R.id.ed_Mobileno);
        EditText edDriverId = findViewById(R.id.ed_driverid);
        EditText edPassword = findViewById(R.id.ed_password);

        String mobileNo = edMobileNo.getText().toString();
        String driverId = edDriverId.getText().toString();
        String password = edPassword.getText().toString();

        class Adddetails extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                DriverDetails driverDetails=new DriverDetails();
                driverDetails.setMobileNumber(mobileNo);
                driverDetails.setDriverId(Integer.parseInt(driverId));
                driverDetails.setName(password);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                finish();
                startActivity(new Intent(getApplicationContext(), AddDetailsActivity.class));
                Toast.makeText(getApplicationContext(), "Details added successfully", Toast.LENGTH_SHORT).show();
                super.onPostExecute(aVoid);
            }
        }
            Adddetails adddetails=new Adddetails();
            adddetails.execute();

    }
}