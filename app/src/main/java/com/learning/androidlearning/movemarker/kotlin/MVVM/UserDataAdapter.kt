package com.learning.androidlearning.movemarker.kotlin.MVVM

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learning.androidlearning.R


class UserDataAdapter(private val userData: List<UserData>, val context: Context) : RecyclerView.Adapter<UserDataViewHolder>() {
    val TAG = "UserDataAdapter"
    val layoutInflater = LayoutInflater.from(context)
    val url="https://www.gstatic.com/webp/gallery3/2.png"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
        val view = layoutInflater.inflate(R.layout.list_item_userdata, parent, false)
        return UserDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        val map: Map<Int, String> = userData.associate { Pair(it.id, it.title) }
        holder.bind(userData[position])
        holder.userDataLayout.setOnClickListener {
            Toast.makeText(context, "Clicked id " + map[userData[position].id] +
                    " and Clicked value " + map[userData[position].title], Toast.LENGTH_LONG).show()
        }
        Glide.with(context)
                .load(url)
                .into(holder.userImage)
        }

    override fun getItemCount(): Int {
        return userData.size
    }
}

class UserDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvUserId: TextView = itemView.findViewById(R.id.tv_userId)
    val tvId: TextView = itemView.findViewById(R.id.tv_id)
    val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    val tvCompleted: TextView = itemView.findViewById(R.id.tv_completed)
    val userDataLayout: CardView = itemView.findViewById(R.id.userdata_layout)
    val userImage: ImageView = itemView.findViewById(R.id.imv_user_image)

    fun bind(user: UserData) {
        tvUserId.text = user.userId.toString()
        tvId.text = user.id.toString()
        tvTitle.text = user.title
        tvCompleted.text = user.completed.toString()
    }
}