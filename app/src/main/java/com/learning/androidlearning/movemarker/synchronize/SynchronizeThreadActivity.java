package com.learning.androidlearning.movemarker.synchronize;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.learning.androidlearning.R;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

public class SynchronizeThreadActivity extends AppCompatActivity {
    private TextView tvShowArrayItems;
    private final String TAG = SynchronizeThreadActivity.class.getSimpleName();
    private ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronize_thread);

        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        thread1.start();
        thread2.start();
    }
    synchronized public void printArrayList()
    {
        for(int i=0;i<integerArrayList.size();i++)
        {
            Log.d(TAG, "printArrayList: "+ integerArrayList.get(i));
        }
    }
    Thread thread1=new Thread(){
        public void run(){
            Log.d(TAG, "thread1: ");
            printArrayList();
           }
    };
    Thread thread2=new Thread(){
        public void run(){
            Log.d(TAG, "thread2: ");
                printArrayList();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread1.interrupt();
        thread2.interrupt();
    }
    /* Thread thread1=new Thread()
         {
             @Override
             public void run() {
                 super.run();
                 integerArrayList.add(120);
                 Log.d(TAG, "thread1: ");
             }
         };
        Thread thread2=new Thread()
        {
            @Override
            public void run() {
                super.run();
                integerArrayList.set(3,5);
                Log.d(TAG, "thread2: ");
            }
        };

        Thread thread3=new Thread()
        {
            @Override
            public void run() {
                super.run();
                Log.d(TAG, "thread3: ");
                Log.d(TAG, "run: "+integerArrayList);
            }
        };
*/
    }
