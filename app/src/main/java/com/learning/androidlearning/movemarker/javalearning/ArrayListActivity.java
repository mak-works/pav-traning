package com.learning.androidlearning.movemarker.javalearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.learning.androidlearning.R;
import com.learning.androidlearning.movemarker.maps.MapsMpveActivity;

import java.util.ArrayList;

public class ArrayListActivity extends AppCompatActivity {

    private ArrayList<Object> diffValuesArrayList = new ArrayList<Object>();
    private GenericClass<Integer> myClassArrayList=new GenericClass();
    private String TAG= ArrayListActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        diffValuesArrayList.add("One");
        diffValuesArrayList.add(11);
        diffValuesArrayList.add(50);
        diffValuesArrayList.add("two");

        myClassArrayList.add(0,50);
        myClassArrayList.add(1,70);
        myClassArrayList.add(2,100);
        myClassArrayList.add(3,500);
        getValues();
        int a=myClassArrayList.get(0);
    }
    private void getValues()
    {
        Log.d(TAG, "getValues: ");
        for (int i = 0; i < myClassArrayList.size(); i++)
        {
            Log.d(TAG, "Different Values arrayList: "+myClassArrayList.get(i));
        }
    }

}

