package com.learning.androidlearning.movemarker.kotlin.Coroutine

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

class ApiUserAdapter(private val apiUsers: List<ApiUser>,val context: Context) : RecyclerView.Adapter<ApiUserDataViewHolder>() {

    val TAG = "ApiUserAdapter"
    val layoutInflater = LayoutInflater.from(context)
    val url="https://www.gstatic.com/webp/gallery3/2.png"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiUserDataViewHolder {
        val view = layoutInflater.inflate(R.layout.item_layout, parent, false)
        return ApiUserDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiUserDataViewHolder, position: Int) {
        holder.bind(apiUsers[position])

    }

    override fun getItemCount(): Int {
        return apiUsers.size
    }
}

class ApiUserDataViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val tvName: TextView = itemView.findViewById(R.id.textView_username)
    val tvEmail: TextView = itemView.findViewById(R.id.textView_useremail)

    fun bind(apiUsers: ApiUser) {
        tvName.text = apiUsers.name
        tvEmail.text = apiUsers.email

    }
}






