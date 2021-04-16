package com.learning.androidlearning.movemarker.kotlin.splash

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learning.androidlearning.R

class UserDataAdapter(val userData: List<UserData>): RecyclerView.Adapter<UserDataViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_userdata, parent, false)
        return UserDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        holder.userId.text= userData.get(position).userId.toString()
        holder.id.text= userData.get(position).id.toString()
        holder.title.text= userData.get(position).title
        holder.completed.text= userData.get(position).completed.toString()
    }

    override fun getItemCount(): Int {
       return userData.size
    }
}

class UserDataViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
     val userId:TextView = itemView.findViewById(R.id.tv_userId)
     val id:TextView = itemView.findViewById(R.id.tv_id)
     val title:TextView = itemView.findViewById(R.id.tv_title)
     val completed:TextView = itemView.findViewById(R.id.tv_completed)

}
