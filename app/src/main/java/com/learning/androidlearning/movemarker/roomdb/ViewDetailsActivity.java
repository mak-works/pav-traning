package com.learning.androidlearning.movemarker.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.learning.androidlearning.R;

import java.sql.Driver;
import java.util.List;

public class ViewDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        getDetails();

    }

    private void getDetails() {


        RecyclerView recyclerView=findViewById(R.id.rv_driverdetails);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        class ViewDriverDetails extends AsyncTask<Void, Void, List<DriverDetails>> {

            @Override
            protected List<DriverDetails> doInBackground(Void... voids) {
                List<DriverDetails> driverDetails= DatabaseClient.
                        getInstance(getApplicationContext()).
                        getDriverDataBase().
                        DriverDetailsDao().
                        getDriverDetails();
                 return driverDetails;

            }

            @Override
            protected void onPostExecute(List<DriverDetails> driverDetails) {
                super.onPostExecute(driverDetails);
                ViewDriverDetailsAdapter viewDriverDetailsAdapter=new ViewDriverDetailsAdapter(ViewDetailsActivity.this,driverDetails);
                recyclerView.setAdapter(viewDriverDetailsAdapter);
            }
        }
        ViewDriverDetails viewDriverDetails=new ViewDriverDetails();
        viewDriverDetails.execute();

    }
}