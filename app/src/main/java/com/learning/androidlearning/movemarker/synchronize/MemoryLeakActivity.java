package com.learning.androidlearning.movemarker.synchronize;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.learning.androidlearning.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MemoryLeakActivity extends AppCompatActivity {

    private final String TAG = MemoryLeakActivity.class.getSimpleName();
    private ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
    private ThreadOne threadOne;
    private ThreadTwo threadTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak);
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        threadOne=new ThreadOne(this);
        threadTwo=new ThreadTwo(this);
        threadOne.start();
        threadTwo.start();
    }
    synchronized public void printArrayList()
    {
        for(int i=0;i<integerArrayList.size();i++)
        {
            Log.d(TAG, "printArrayList: "+ integerArrayList.get(i));
        }
    }
    private static class ThreadOne extends Thread
    {
        private WeakReference<MemoryLeakActivity> weakReferenceOne;

        public ThreadOne(MemoryLeakActivity memoryLeakActivity)
        {
            weakReferenceOne=new WeakReference<>(memoryLeakActivity);
        }

        @Override
        public void run() {
            MemoryLeakActivity memoryLeakActivity=weakReferenceOne.get();
            if (!currentThread().isInterrupted()) {
                memoryLeakActivity.printArrayList();
            }
            super.run();
        }
    }
    private static class ThreadTwo extends Thread
    {
        private WeakReference<MemoryLeakActivity> weakReferenceTwo;

        public ThreadTwo(MemoryLeakActivity memoryLeakActivity)
        {
            weakReferenceTwo=new WeakReference<>(memoryLeakActivity);
        }

        @Override
        public void run() {
            MemoryLeakActivity memoryLeakActivity=weakReferenceTwo.get();
            if(!currentThread().isInterrupted())
            {
                memoryLeakActivity.printArrayList();
            }
            super.run();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        threadOne.interrupt();
        threadTwo.interrupt();

    }
}