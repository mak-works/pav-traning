package com.learning.androidlearning.movemarker.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.learning.androidlearning.R

class CollectionsActivity : AppCompatActivity() {
    var TAG:String="CollectionsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collections)
        printList()
        printSet()
        printMap()
        printArrayList()

    }

    private fun printList() {
        //List is an ordered collection it maintains the insertion order,allow dublicate elements
        val listOne = listOf(1,2,3)// Immutable list - does not support adding,removing functions same as set,Map
        for(i in listOne)
        {
            Log.d(TAG, "printList: "+i)
        }
        Log.d(TAG, "List Size: "+listOne.size)
        Log.d(TAG, "Value of Second Position: "+listOne.get(1))
        Log.d(TAG, "Value of Third Position: "+listOne[2])
        Log.d(TAG, "First Element: "+listOne.first())
        val listDes = listOne.sortedDescending();
        var result=listOne.contains(0)
        Log.d(TAG, "List in Descending order: "+listDes)
        if(result)
        {
            Log.d(TAG, "List contain 0: ")
        }
        else
        {
            Log.d(TAG, "List does not contain 0: ")
        }

        var listTwo = mutableListOf("Coimbatore","Madurai","Chennai") //Mutable list  - you can add and remove the list

        for(i in listTwo)
        {
            Log.d(TAG, "printList two Mutable : "+listTwo)
        }
        listTwo.add("Tirchy")
        listTwo.remove("Madurai")

        for(i in listTwo)
        {
            Log.d(TAG, "After adding Tirchy remove Madurai Changed list is : "+listTwo)
        }
    }
    private fun printSet()
    {
        //Set is an unordered collection,does not allow dublicate elements
        //Immutable set
        val setOne = setOf(1,2,3,"Chennai","Coimbatore","Tirchy")
        for(i in setOne)
        {
            Log.d(TAG, "printSet: "+i)
        }
        Log.d(TAG, "List Size: "+setOne.size)
        Log.d(TAG, "Value of Third Position: "+setOne.elementAt(1))
        Log.d(TAG, "Position of Tirchy is : "+setOne.indexOf("Tirchy"))
        var result= setOne.contains("Coimbatore")
        if(result)
        {
            Log.d(TAG, "The list contain Coimbatore: ")
        }
        else
        {
            Log.d(TAG, "The list does contain Coimbatore: ")
        }

        //Mutable set same as HashSet
        val setTwo = mutableSetOf<String>("Salem","Kanniya kumari","Naga Paddinam")
        for(i in setTwo)
        {
            Log.d(TAG, "printSet two Mutable set: "+setTwo)
        }
        setTwo.add("Namakkal")
        setTwo.remove("Naga Paddinam")
        for(i in setTwo)
        {
            Log.d(TAG, "After adding Namakkal remove Naga Paddinam Changed set is : "+setTwo)
        }

        val hashSet = hashSetOf<Int>(1,2,3);
        hashSet.add(5)
        for(i in hashSet)
        {
            Log.d(TAG, "hashSet: "+i)
        }


    }

    private fun printMap()
    {
        var mutableMap = mutableMapOf<Int,String>(1 to "Pavithra",2 to "Jaya",3 to "Dhaarani")
        for(i in mutableMap)
        {
            Log.d(TAG, "printMapKey: "+i.key)
            Log.d(TAG, "printMapValues: "+i.value)
        }
        Log.d(TAG, "printMap Size: "+mutableMap.size)
        Log.d(TAG, "printMap getValue "+mutableMap[2])
        if(mutableMap.containsKey(3))
        {
            Log.d(TAG, "The Map contain the key 3: ")
        }
        else
        {
            Log.d(TAG, "The Map does not contain the key 3: ")
        }
        if(mutableMap.containsValue("Dhaarani"))
        {
            Log.d(TAG, "The map contain the value Dhaarani ")
        }
        else
        {
            Log.d(TAG, "The map does not contain the value Dhaarani: ")
        }
        mutableMap.put(3,"Moorthi")
        /*for ( i in mutableMap)
        {
            Log.d(TAG, "After adding the value the Map is "+i)
        }*/
        Log.d(TAG, "After adding the value Dhaarani the Map is "+mutableMap.entries)



        //Hash Map is same as Mutable Map
        var hashMap : HashMap<Int, Int>
                = HashMap<Int, Int> ()
        hashMap.put(1,1)
        hashMap.put(2,1)

        for(i in hashMap)
        {
            Log.d(TAG, "hashMap: "+hashMap)
        }

    }
    private fun printArrayList()
    {
        var arrayListOne = ArrayList<String>()
        arrayListOne.add("Pavithra")
        arrayListOne.add("Jaya")

        for(i in arrayListOne)
        {
            Log.d(TAG, "printArrayList: "+i)
        }
        Log.d(TAG, "index of Pavithra"+arrayListOne.indexOf("Pavithra"))
        arrayListOne.clear()

            Log.d(TAG, "After clearing the arrayList size is : " +arrayListOne.size)
            Log.d(TAG, "After clearing the arrayList is: "+arrayListOne)
    }

}