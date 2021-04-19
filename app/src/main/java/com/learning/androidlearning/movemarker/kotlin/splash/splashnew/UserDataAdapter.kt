package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonArray
import com.learning.androidlearning.R


class UserDataAdapter(val userData: List<UserData>,var context:Context): RecyclerView.Adapter<UserDataViewHolder>(){
    val TAG = "UserDataAdapter"
    init {
        this.context=context;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_userdata, parent, false)
        return UserDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        val map: Map<Int, String> = userData.associate { Pair(it.id, it.title) }
        holder.userId.text= userData.get(position).userId.toString()
        holder.id.text= userData.get(position).id.toString()
        holder.title.text= userData.get(position).title
        holder.completed.text= userData.get(position).completed.toString()
        holder.userDataLayout.setOnClickListener(View.OnClickListener {
            Log.d(TAG, "onBindViewHolder: " + userData.get(position).id)
            for (i in map) {
                if (userData.get(position).id == i.key) {
                    Log.d(TAG, "Map id : " + i.key)
                    Log.d(TAG, "Map value: "+i.value)
                    val Toast=Toast.makeText(context,"Clicked id " +i.key+" and Clicked value " +i.value,Toast.LENGTH_LONG)
                    Toast.show();
                }
            }
        })
    }

    override fun getItemCount(): Int {
       return userData.size
    }
  }
     class UserDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
     val userId:TextView = itemView.findViewById(R.id.tv_userId)
     val id:TextView = itemView.findViewById(R.id.tv_id)
     val title:TextView = itemView.findViewById(R.id.tv_title)
     val completed:TextView = itemView.findViewById(R.id.tv_completed)
     val userDataLayout:ConstraintLayout=itemView.findViewById(R.id.userdata_layout)
     }
