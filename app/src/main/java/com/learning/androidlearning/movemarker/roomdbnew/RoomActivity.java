package com.learning.androidlearning.movemarker.roomdbnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.roomdb.AddDetailsActivity;
import com.learning.androidlearning.movemarker.roomdb.DatabaseClient;
import com.learning.androidlearning.movemarker.roomdb.ViewDriverDetailsAdapter;
import com.learning.androidlearning.movemarker.taxiui.ForegroundService;
import com.learning.androidlearning.movemarker.taxiui.utils.MyAppConstants;

import java.io.Serializable;
import java.util.List;

public class RoomActivity extends AppCompatActivity {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    RecyclerView recyclerView;
    private String TAG=RoomActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        Button add = findViewById(R.id.add);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(RoomActivity.this));
        startService();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomActivity.this, AddDriverActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });

        class ViewDetails extends AsyncTask<Void, Void, List<com.learning.androidlearning.movemarker.roomdb.DriverDetails>> {

            @Override
            protected List<com.learning.androidlearning.movemarker.roomdb.DriverDetails> doInBackground(Void... voids) {

                DriverDetailRepository driverDetailRepository=new DriverDetailRepository(getApplication());
                List<com.learning.androidlearning.movemarker.roomdb.DriverDetails> driverDetails=driverDetailRepository.getAllDriverDetails();
                return driverDetails;
            }

            @Override
            protected void onPostExecute(List<com.learning.androidlearning.movemarker.roomdb.DriverDetails> driverDetails) {

                ViewDriverDetailsAdapter viewDriverDetailsAdapter=new ViewDriverDetailsAdapter(RoomActivity.this,driverDetails);
                recyclerView.setAdapter(viewDriverDetailsAdapter);
            }
        }

        ViewDetails viewDriverDetails=new ViewDetails();
        viewDriverDetails.execute();
    }

    public void startService()
    {
        Log.d(TAG, "startService: ");
        Intent serviceIntent = new Intent(this, ForegroundService.class);
        startService(serviceIntent);
    }

}
