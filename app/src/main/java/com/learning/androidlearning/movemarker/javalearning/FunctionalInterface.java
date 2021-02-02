package com.learning.androidlearning.movemarker.javalearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.learning.androidlearning.R;

public class FunctionalInterface extends AppCompatActivity {
    Runnable firstRunable;
    private String TAG=FunctionalInterface.class.getSimpleName();
    MyfunctionalInterface myfunctionalInterface;
    int giveNumber=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functional_interface);

        //example of Functional interface
        firstRunable=new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: ");
            }
        };

        Thread thread = new Thread(firstRunable);
        thread.start();

        //passing lambda expression to the functionalInterface
        myfunctionalInterface=(int a) -> { return a=a+10; };
        int result=myfunctionalInterface.add(giveNumber);
        Log.d(TAG, "result: "+result);

    }


    @java.lang.FunctionalInterface
    public interface MyfunctionalInterface
    {
       int add(int a);
    }




}