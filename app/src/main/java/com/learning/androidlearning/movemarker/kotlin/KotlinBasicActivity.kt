package com.learning.androidlearning.movemarker.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.learning.androidlearning.R

class KotlinBasicActivity : AppCompatActivity() {

  /*  kotlin all data types are primitive data types - Int,Float,Double,Char,Boolean-use wrapper class for primitive-
     When it convert to JVM code kotlin primitive convert to java primitive-behave like objects
    reference type is Array,String,Classes,Interfaces*/

    private var intVal: Int = 35
    private var intValneW: Int = 40
    private var floatVal: Float = 5.3F
    private var strVal: String = "Pavithra"
    private var dobVal: Double = 11.3
    private var char: Char = 'a'
    var lastName: String? = null

    private var myNewValue = 50
    private var floatValNew = 5.5
    private var strValNew = "Pavithra S"
    private var dobValNew = 11.3
    private var num: Any = 10.33
    private val immutValue = "50"  //value cannot be changed means reassign not accept

    private val TAG: String = "KotlinBasicActivity" //without data type we can decalre

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_type_kotlin)
        printVaribales()
        printOperators()
        typeConversion()
        ifInsteadOfTernary()
        printForLoop()
        whenInsteadOfSwitch()
        var returnValue=functionWithArguementandReturn(num)
        functionWithArguementDirectPass("Things")
        Log.d(TAG, "returnValue: "+returnValue)


    }

    private fun printVaribales() {
        Log.d(TAG, "IntVal: " + intVal)
        Log.d(TAG, "floatVal: " + floatVal)
        Log.d(TAG, "strVal: " + strVal)
        Log.d(TAG, "dobVal: " + dobVal)
        Log.d(TAG, "char: " + char)
        Log.d(TAG, "myNewValue: " + myNewValue)
        Log.d(TAG, "floatValNew: " + floatValNew)
        Log.d(TAG, "strValNew: " + strValNew)
        Log.d(TAG, "dobValNew: " + dobValNew)
        Log.d(TAG, "immutValue: " + immutValue)
    }

    private fun printOperators() {
        Log.d(TAG, "Multiplication: " + intVal * myNewValue)
        Log.d(TAG, "Reminder: " + intVal % myNewValue)
        Log.d(TAG, "printOperators: " + (intVal > intValneW));
        Log.d(TAG, "printOperators: " + (10.shl(5)));
        //All operators all like java except bitwise shl
    }

    private fun typeConversion() {
        Log.d(TAG, "toString: " + intVal.toString()) //string to int
        Log.d(TAG, "toLong: " + intVal.toLong())
        var str: String = intVal.toString()//int to string
        Log.d(TAG, "Int to String: " + str)
        /*helper functions are toByte()
        toShort()
        toInt()
        toLong()
        toFLoat()
        toDouble()
        toChar()*/
    }

    private fun ifInsteadOfTernary() {
        Log.d(TAG, "ifinsteadOfTernary: " + if (intVal > intValneW) intVal else intValneW)
    }

    private fun printForLoop() {
        //labeled break
        outer@ for (i in 1..20) {
            if (i == 5)
                break@outer;
            Log.d(TAG, "labeled printForLoop: " + i)
        }

        //unlabelled break
        for (i in 1..20) {
            if (i == 5)
                break;
            Log.d(TAG, "un labeledprintForLoop: " + i)
        }

        for (i in 1..5 step 3) {
            Log.d(TAG, "printForLoop: with step " + i)
            break;
        }
        for (i in 5 downTo 1) {
            Log.d(TAG, "printForLoop:downTo " + i)
            break;
        }
        for (i in 10 downTo 1 step 2) {
            Log.d(TAG, "printForLoop downto plus step: " + i)
            break;
        }
    }

    private fun whenInsteadOfSwitch() {
        var i = 10;
        when (i) {
            1 -> Log.d(TAG, "WhenInsteadOfSwitch: The variable values is 1")
            2 -> Log.d(TAG, "WhenInsteadOfSwitch: The variable values is 2 ")
            else -> Log.d(TAG, "The variable does not contain 1 and 2")
        }
        for (i in 1..10) {
            when (i) {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10 -> Log.d(TAG, "The number is between one to 10: ")
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20 -> Log.d(TAG, "The number is between 11 to 20: ")
            }
        }


    }

    //functions
    private fun functionWithArguementandReturn(floatNumber: Any): Any {
        when (floatNumber) {
            is Int -> Log.d(TAG, "The num value is Int: ")
            is Float -> Log.d(TAG, "The num value is Float: ")
            is Double -> Log.d(TAG, "The num value is Double: ")

        }
        return floatNumber;
    }
    //functions with arguement direct passing
    private fun functionWithArguementDirectPass(value: Any): Any {
        when (value) {
            is Int -> Log.d(TAG, "The num value is Int: ")
            is Float -> Log.d(TAG, "The num value is Float: ")
            is Double -> Log.d(TAG, "The num value is Double: ")
            is String -> Log.d(TAG, "The num value is String ")

        }
        return value;
    }




}
