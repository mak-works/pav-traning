package com.learning.androidlearning.movemarker.kotlin.MVVM

import com.google.gson.annotations.SerializedName

data class UserData(
        @SerializedName("userId")
        var userId: Int,
        @SerializedName("id")
        var id: Int,
        @SerializedName("title")
        var title: String,
        @SerializedName("completed")
        var completed: Boolean)