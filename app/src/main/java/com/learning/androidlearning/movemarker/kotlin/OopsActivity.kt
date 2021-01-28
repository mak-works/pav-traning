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
        execution()



    }
    //Nested class
    class myClass
    {

        class nestedClassOne
        {
            var TAG="NestedClass"
            var varOne=10;
            var varTwo=20;
            var varThree=30

            fun add()
            {
                varThree=varOne+varTwo;
                Log.d(TAG, "add nested class: "+varThree)
            }

        }
    }
    //inner class

    class myClassTwo
    {
        var TAG="InnerClass"
        var varOne=10;
        var varTwo=20;
        var varThree=30

        inner class innerClassOne
        {
            fun add()
            {
                varThree=varOne+varTwo;
                Log.d(TAG, "add inner class: "+varThree)
            }

        }
    }
    
    fun execution()
    {
        val nested =myClass.nestedClassOne()
        nested.add()

        val myClassTwoOuter=myClassTwo()
        myClassTwoOuter.innerClassOne().add()
    }






}