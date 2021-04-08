package com.learning.androidlearning.movemarker.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AndroidException
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

    //Cutom accessor
    class CustomAccessor(var nameOne:String,var nameTwo:String)
    {
        val isAccess:Boolean
        get()
        {
            return nameOne==nameTwo;
        }
    }

    //Constructors
    class PrimaryConstructor(val a:Int,val b:Int=5)
    {
       val c=a+b;
    }
    class SecondaryConstructor()
    {
        var c: Int? = null
        constructor(a:Int,b:Int) : this() {
            c =a+b;
        }
        constructor(a:Int,b:Int,d:Int) : this() {
            c =a+b+d;
        }

    }

    //Inheritance
    open class InheritanceBaseClass()
    {
        var baseClasName: String ="inheritancebaseClass"
    }
    class InheritanceDerivedClass():InheritanceBaseClass()
    {
        var TAG="InheritanceDerivedClass"
        var drivedClassName: String ="InheritanceDerivedClass"

        fun printValues()
        {
            Log.d(TAG, "baseClasName: "+baseClasName)
            Log.d(TAG, "drivedClassName: "+drivedClassName)
        }
    }

    //Inheritance with primary constructor
    open class Language(var launguage:String)
    {
        var TAG="Language"
        init {
            Log.d(TAG, launguage+" is a programming lanuguage")
        }
    }
    class Java(var usedLanguage:String): Language(usedLanguage)
    {
        fun print()
        {
            Log.d(TAG, "Used for Android ")
        }
    }
    class Html(var usedLanguage:String): Language(usedLanguage)
    {
        fun print()
        {
            Log.d(TAG, "Used for Web ")
        }
    }

    //Inheritance with secondary constructor
    open class Employee {
        var TAG="Employee"
        open var exp:Int=1;
        constructor(name: String){
            Log.d(TAG, "Name of the Employee is "+name)
        }
    }
    // derived class
    class AndroidDeveloper : Employee{
        override var exp=2;
        constructor( name: String,salary: Double): super(name) {
            Log.d(TAG, "Salary per annum is " +salary)
            Log.d(TAG, "Experience is" +exp)
        }
    }

    //interface

    interface InterfaceOne {
        var a : Int
        val b : String
            get() = "Pavithra"
    }
    interface InterfaceTwo:InterfaceOne
    {
        fun printValues()
    }
    interface InterfaceThree:InterfaceTwo
    {
        val c : Int
            get() = 1000
    }

    class PropertiesDemo : InterfaceThree {
        var TAG="PropertiesDemo"
        override var a : Int = 5000
        override val b : String = "Property Overridden"
        override var c : Int = 2000

        override fun printValues()
        {
            Log.d(TAG, "value a: "+a)
            Log.d(TAG, "value b: "+b)
            Log.d(TAG, "value c: "+c)
        }
    }

    //Abstract class
    abstract class abstractClass()
    {
        var TAG="Furniture"
        //abstract
        abstract var furnitureSecond : String
        abstract fun printFurnitures()

        //nonAbstract
        open var furnitureFirst: String="Beero"
        open fun printNewFurnitures()
        {
            Log.d(TAG, "printNewFurnitures: "+furnitureFirst)
        }

    }
    class Furniture:abstractClass()
    {

        override var furnitureSecond="Soffa"
        override var furnitureFirst="Chair"
        override fun printFurnitures()
        {
            Log.d(TAG, "printFurnitures: "+furnitureSecond)
        }
        override fun printNewFurnitures()
        {
            Log.d(TAG, "printNewFurnitures: "+furnitureFirst)
            Log.d(TAG, "The function overrided")
        }
    }

    //Enum class

    enum class ProgrammingLaunguages
    {
        Java,HTML,CSS,PHP,Laravel;
        companion object
        {

        }
    }


    //extensionfunctions
    class Arithmetic(var a:Int,var b:Int)
    {
        var TAG="Arithmetic"
        fun add()
        {
            var c=a+b;
            Log.d(TAG, "added: "+c)
        }
    }
    fun Arithmetic.mul(a:Int,b:Int)
    {
        var c=a*b;
        Log.d(TAG, "multiplied: "+c)
    }

    //Sealed class
    sealed class add()
    {
        var TAG="sealed"
        class addOne(a:Int,b:Int)
        {
            var z=a+b
        }
        class addTwo(a:Int,b:Int,c:Int)
        {
            var z=a+b+c;
        }
    }
    //Data class
    data class Product(var item: String, var price: Int)


    fun execution()
    {
        val nested =myClass.nestedClassOne()
        nested.add()

        val myClassTwoOuter=myClassTwo()
        myClassTwoOuter.innerClassOne().add()

        val customAccessor=CustomAccessor("Pavithra","Jaya")
        Log.d(TAG, "execution: "+customAccessor.isAccess)

        val primaryConstructor=PrimaryConstructor(5)
        Log.d(TAG, "PrimaryConstructor: "+primaryConstructor.c)

        val secondaryConstructorOne=SecondaryConstructor(10,10);
        Log.d(TAG, "secondaryConstructor: "+secondaryConstructorOne.c)

        val secondaryConstructorTwo=SecondaryConstructor(10,10,10);
        Log.d(TAG, "secondaryConstructor: "+secondaryConstructorTwo.c)

        val inheritanceDerivedClass=InheritanceDerivedClass();
        inheritanceDerivedClass.printValues()

        val java=Java("Java")
        java.print()
        val html=Html("HTML")
        html.print()

        val AndroidDeveloper=AndroidDeveloper("Pavithra",250.000);

        val PropertiesDemo=PropertiesDemo()
        PropertiesDemo.printValues()

        val furniture=Furniture()
        furniture.printFurnitures()
        furniture.printNewFurnitures()

        for(laung in ProgrammingLaunguages.values())
        {
            Log.d(TAG, "ProgrammingLaunguages: "+laung)
        }
        when(ProgrammingLaunguages.HTML)
        {
            ProgrammingLaunguages.HTML -> Log.d(TAG, "Given launguage is HTML")
            ProgrammingLaunguages.CSS -> Log.d(TAG, "Given launguage is CSS")
            ProgrammingLaunguages.Java -> Log.d(TAG, "Given launguage is CSS")
            ProgrammingLaunguages.Laravel -> Log.d(TAG, "Given launguage is Laravel")
            ProgrammingLaunguages.PHP -> Log.d(TAG, "Given launguage is PHP")
        }

        Log.d(TAG, "Value of Second Position"+ProgrammingLaunguages.valueOf("HTML"))

        val Arithmetic=Arithmetic(10,10)
        Arithmetic.add()
        Arithmetic.mul(10,10)


        val addOne=add.addOne(10,10)
        Log.d(TAG, "Sealed class one value: "+addOne.z)

        val addTwo=add.addTwo(10,10,10)
        Log.d(TAG, "Sealed class two value: "+addTwo.z)

        val p1 = Product("laptop", 25000)
        val p2=p1.copy()//operatorone

        val componentOne = p2.component1()//operatortwo
        val componentTwo = p2.component2()
        Log.d(TAG, "componentOne: "+componentOne)
        Log.d(TAG, "componentTwo: "+componentTwo)
        Log.d(TAG, "equals operator: "+p1.equals(p2)) //operatorthree


    }










}