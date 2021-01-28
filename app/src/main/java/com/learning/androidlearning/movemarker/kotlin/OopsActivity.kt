package com.learning.androidlearning.movemarker.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.learning.androidlearning.R

class OopsActivity : AppCompatActivity() {

     var varOne=10;
     var varTwo=20;
     var varThree=30
    var TAG="OopsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oops)

        //Java inner class
        //inner class have access the members of the outer class if they decared as private
        //treated as variable menmbers function
        //we can use the access modifiers private,public,protected
        //not static class - inner class

        //Java Nested class
        //Nested class cannot have access the members of the outer class
        //declared as static
        //it provide better encapsulation
        //static class - Nested class
        Log.d(TAG, "onCreate: "+NestedClassOne.)



    }
    //Nested class
    class NestedClassOne
    {
        var TAG="NestedClass"
        var varOne=10;
        var varTwo=20;
        var varThree=30

        fun add()
        {
            varThree=varOne+varTwo;
            Log.d(TAG, "add: "+varThree)
        }

    }





}