package com.learning.androidlearning.movemarker.taxiui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.taxiui.utils.ShiftOutDialog;

public class ProfileActivity extends AppCompatActivity {
    Button btn_save,btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilenew);
        btn_save=findViewById(R.id.btn_save);
        btn_logout=findViewById(R.id.btn_logout);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShiftOutDialog shiftOutDialog=new ShiftOutDialog(ProfileActivity.this);
                shiftOutDialog.setCancelable(true);
                shiftOutDialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttonbackground));
                shiftOutDialog.show();
                shiftOutDialog.setMessage("You have clicked save");
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShiftOutDialog shiftOutDialog=new ShiftOutDialog(ProfileActivity.this);
                shiftOutDialog.setCancelable(true);
                shiftOutDialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttonbackground));
                shiftOutDialog.show();
                shiftOutDialog.setMessage("You have clicked logout");
            }
        });


    }
}