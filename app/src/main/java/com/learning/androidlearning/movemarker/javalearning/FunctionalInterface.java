package com.learning.androidlearning.movemarker.javalearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.learning.androidlearning.R;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterface extends AppCompatActivity {
    Runnable firstRunable;
    private String TAG=FunctionalInterface.class.getSimpleName();
    MyfunctionalInterface myfunctionalInterface;
    int giveNumber=10;
    ArrayList<String> newList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functional_interface);
        newList.add("One");
        newList.add("Two");
        newList.add("Three");

        //example of Functional interface
        firstRunable=new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: ");
            }
        };

        Thread thread = new Thread(firstRunable);
        thread.start();


        //Build in functions
        Predicate<String> p = (s)->s.startsWith("O");
        Log.d(TAG, "onCreate: "+p);



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