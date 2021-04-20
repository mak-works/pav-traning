package com.learning.androidlearning.movemarker.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.learning.androidlearning.R;

public class MapsMpveActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMap;
    ImageView locationMarker;
    String TAG=MapsMpveActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_mpve);
        locationMarker=findViewById(R.id.myMap);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;

        mMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                Log.d(TAG, "onCameraMove: ");

            }
        });


    }
}