package com.learning.androidlearning.movemarker.taxiui.utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.learning.androidlearning.R;

public class ShiftOutDialog extends Dialog {

    private TextView tvShiftOut;
    private ImageView dialogImage;

    public ShiftOutDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shiftoutdialog);
        tvShiftOut = findViewById(R.id.tv_shiftout);
        dialogImage = findViewById(R.id.location_img);
        findViewById(R.id.btn_ok).setOnClickListener(v -> dismiss());
    }

    public void setMessage(String message) {
        tvShiftOut.setText(message);
        dialogImage.setVisibility(View.GONE);

    }

}
