package com.learning.androidlearning.movemarker.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.learning.androidlearning.R

class KotlinFunctionsActivity : AppCompatActivity() {
     val TAG:String ="ArrayActivity"
    private var num: Any = 10.33


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_functions)
        val expeOne={a:Int,b:Int->a%b}
        val exprTwo={a:Int,b:Int->a+b}
        val exprThree : String.(Int) -> String = { this + it }
        val anonymousfun = fun(x: Int, y: Int): Int = x + y

        var exprOneResult=functionWithArguementandReturn(num)
        var expTwoResult=exprTwo(2,4)
        var expThreeResult="Extension function".exprThree(50)
        var anonymousfunResult=anonymousfun(7,10)

        Log.d(TAG, "functionWithArguementandReturn: "+exprOneResult)
        Log.d(TAG, "direct pass lambda: "+expTwoResult)
        Log.d(TAG, "Extension function: "+expThreeResult)
        Log.d(TAG, "anonymousfunResult "+anonymousfunResult)

        highOrderPassingLambda(expeOne)
        highOrderPassingFunction(::div)
        functionWithArguementDirectPass("Things")
    }

   /* High order functions
    Passing the functions and lambdas as arguement in function is called High Order function
    Lambda expression returns unit and strings*/

   /* lambda Syntax
    Lambda expression is a simplified representation of a function
   val lambdaName : Type = { argumentList -> codeBody }
*/

  /*  use of the inline function is does not allocate memory for the high order function
      it tells to the compiler to copy the code of highorder function when it is call*/



    fun highOrderPassingLambda( lmbd: (a:Int,b:Int) ->Int )
    {
        var result=lmbd (10,4)
        Log.d(TAG, "highOrder Passing Lambda result "+result)
    }
    fun div(a:Int,b:Int):Double
    {
       return a/b.toDouble();
    }
    inline fun highOrderPassingFunction(div:(Int,Int) -> Double)
    {
        div(10,5)
        Log.d(TAG, "highOrderPassingFunction executed")
        Log.d(TAG, "highOrderPassingFunction: "+div(10,5))
        return
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