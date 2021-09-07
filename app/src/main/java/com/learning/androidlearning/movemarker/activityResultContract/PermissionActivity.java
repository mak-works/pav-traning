package com.learning.androidlearning.movemarker.activityResultContract;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.learning.androidlearning.R;

public class PermissionActivity extends AppCompatActivity {

    private PermissionFragment permissionFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        permissionFragment = PermissionFragment.newInstance();
        Utils.addFragmentToActivity(getSupportFragmentManager(), permissionFragment, R.id.fr_container);
    }
}