package com.dev_mahmoud_ashraf.baseapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
@Entity(tableName = "JobsResopnse")
data class JobsResopnse(

 @PrimaryKey
 @field:SerializedName("id")
 var id: Int? = null)