package com.dev_mahmoud_ashraf.baseapp.data.models
import com.google.gson.annotations.SerializedName


/**
 * Created by dev.mahmoud_ashraf on 12/16/2019.
 */
 data class PostsResponse(
    @SerializedName("body")
    val body: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("userId")
    val userId: Int? = 0
)