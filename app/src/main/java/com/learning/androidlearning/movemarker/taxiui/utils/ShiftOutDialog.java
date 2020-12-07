package com.learning.androidlearning.movemarker.taxiui.utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.learning.androidlearning.R;

public class ShiftOutDialog extends Dialog {

    TextView tvShiftout;
    ImageView dialogImage;
    Button okButton;

    public ShiftOutDialog(@NonNull Context context) {
        super(context);

    };
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shiftoutdialog);
        tvShiftout=findViewById(R.id.tv_shiftout);
        dialogImage=findViewById(R.id.location_img);
        okButton=findViewById(R.id.btn_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
    public void setMessage(String message)
    {
        tvShiftout.setText(message);
        dialogImage.setVisibility(View.GONE);

    }

}
