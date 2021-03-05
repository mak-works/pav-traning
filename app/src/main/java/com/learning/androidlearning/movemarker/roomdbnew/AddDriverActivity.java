package com.learning.androidlearning.movemarker.roomdbnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.roomdb.AddDetailsActivity;
import com.learning.androidlearning.movemarker.roomdb.DatabaseClient;
import com.learning.androidlearning.movemarker.roomdb.DriverDetails;
import com.learning.androidlearning.movemarker.taxiui.ForegroundService;
import com.learning.androidlearning.movemarker.taxiui.utils.MyAppConstants;
import java.util.List;

public class AddDriverActivity extends AppCompatActivity {

    private String TAG=AddDriverActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);
        Button btn_save = findViewById(R.id.btn_add);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDetails();
            }
        });
    }

    private void addDetails() {
        EditText ed_id = findViewById(R.id.ed_driverid);
        EditText ed_name = findViewById(R.id.ed_name);
        EditText ed_mobileNumber = findViewById(R.id.ed_Mobileno);
        String driverId = ed_id.getText().toString();
        String name = ed_name.getText().toString();
        String mobileNo = ed_mobileNumber.getText().toString();

        class Adddetails extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                DriverDetails driverDetails = new DriverDetails();
                driverDetails.setDriverId(Integer.parseInt(driverId));
                driverDetails.setMobileNumber(mobileNo);
                driverDetails.setName(name);
                DriverDetailRepository driverDetailRepository=new DriverDetailRepository(getApplication());
                driverDetailRepository.insert(driverDetails);
                return null;

            }

            @Override
            protected void onPostExecute(Void aVoid) {
                finish();
                Toast.makeText(getApplicationContext(), "Details added successfully", Toast.LENGTH_SHORT).show();
                super.onPostExecute(aVoid);
                Intent intent=new Intent(AddDriverActivity.this,RoomActivity.class);
                startActivity(intent);
            }
        }
        Adddetails adddetails = new Adddetails();
        adddetails.execute();
    }
}






