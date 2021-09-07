package com.learning.androidlearning.movemarker.activityResultContract;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.learning.androidlearning.R;

public class PermissionFragment extends Fragment implements View.OnClickListener{

    private Button btnRequestPermission,btnCheckPermission;
    private FragmentActivity fr;
    private String TAG="PermissionFragment";
    public static final int CALL_PERMISSION = 101;
    public static PermissionFragment newInstance() {
        return new PermissionFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentActivity)
        {
            fr=(FragmentActivity)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_permission, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnRequestPermission=view.findViewById(R.id.btn_request_permission);
        btnCheckPermission=view.findViewById(R.id.btn_check_permission);
        btnRequestPermission.setOnClickListener(this);
        btnCheckPermission.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_request_permission:
                checkPermissionGranted();

                case R.id.btn_check_permission:
                checkCallPermission();
        }
    }

    private void checkPermissionGranted() {
        new FragmentPermissionHelper().startPermissionFragment(fr,new FragmentPermissionInterface() {
            @Override
            public void onGranted(boolean isGranted) {
                if (isGranted) {
                    boolean isLocPermitted = PermissionUtils.isPermissionGranted(getContext(), Manifest.permission.CALL_PHONE);
                    if(isLocPermitted)
                    {
                        Toast.makeText(fr, "Permission granted", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            CALL_PERMISSION);
                }
            }
        },Manifest.permission.CALL_PHONE);
    }

    private void checkCallPermission() {
        boolean isLocPermitted = PermissionUtils.isPermissionGranted(getContext(), Manifest.permission.CALL_PHONE);
        if(isLocPermitted)
        {
            Toast.makeText(fr, "Permission granted", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Permission granted: ");
        }
        else
        {
            Log.d(TAG, "not granted: ");
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE},
                    CALL_PERMISSION);
        }
    }
}