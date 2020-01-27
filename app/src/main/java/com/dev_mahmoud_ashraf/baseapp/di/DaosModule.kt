package com.dev_mahmoud_ashraf.baseapp.di

import com.dev_mahmoud_ashraf.baseapp.data.daos.RemoteServiceDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by dev.mahmoud_ashraf on 12/11/2019.
 */
@Module
object DaosModule {
    @Provides
    @Singleton
    fun provideRemoteServiceDao(retrofit: Retrofit): RemoteServiceDao {
        return retrofit.create(RemoteServiceDao::class.java)
    }

  /**  @Provides
    @Singleton
    fun provideLocalJobsDao(database: Database): LocalJobsDao {
        return database.localJobsDao()
    }*/

}