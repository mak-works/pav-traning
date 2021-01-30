package com.learning.androidlearning.movemarker.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.learning.androidlearning.R

class KotlinFunctionsActivity : AppCompatActivity() {
     val TAG:String ="ArrayActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_functions)
        var expe={a:Int,b:Int->a%b}
        highOrderPassingLambda(expe)
        highOrderPassingFunction(::div)

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






}