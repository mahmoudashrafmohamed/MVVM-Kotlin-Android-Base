package com.dev_mahmoud_ashraf.baseapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev_mahmoud_ashraf.baseapp.data.models.JobsResopnse

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */

@Database(entities = [JobsResopnse::class/*, Issue::class*/], version = 1)
abstract class Database : RoomDatabase() {

  //  abstract fun localJobsDao(): LocalJobsDao

    //abstract fun localIssuesDao(): LocalIssuesDao
}