package com.learning.androidlearning.movemarker.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.learning.androidlearning.R

class ArrayActivity : AppCompatActivity() {
    private val TAG:String ="ArrayActivity"
    val arrayTypeOne = arrayOf(1, 2, 3, 4)
    val arrayTypeTwo=arrayOf<Int>(1,2,3,4,5)
    val arrayTypeFour= intArrayOf(1,2,3,4,5);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array)

        printArray();

    }

    private fun printArray() {
        //printing array
        for(i in arrayTypeOne.indices)
        {
            Log.d(TAG, "printArrayOne: "+arrayTypeOne[i])
        }

        for(i in 0..arrayTypeTwo.size-1)
        {
            Log.d(TAG, "printArrayTwo: "+arrayTypeTwo[i])
        }
        //getting array
        Log.d(TAG, "get value"+arrayTypeOne.get(3))
        Log.d(TAG, "get value: "+arrayTypeTwo[2])

        //setting array
        arrayTypeOne.set(3,5);
        arrayTypeTwo[2]=50

        for(i in arrayTypeOne.indices)
        {
            Log.d(TAG, "printArrayOne:after setting "+arrayTypeOne[i])
        }

        for(i in 0..arrayTypeTwo.size-1)
        {
            Log.d(TAG, "printArray after setting: "+arrayTypeTwo[i])
        }


        //print the array with position
        for((index,value) in arrayTypeOne.withIndex())
        {
            Log.d(TAG, "Position : "+index)
            Log.d(TAG, "Value: "+value)
        }
        //Collection store multiple data type
    }

}