package com.dev_mahmoud_ashraf.baseapp.di

import com.dev_mahmoud_ashraf.baseapp.data.daos.RemoteServiceDao
import com.dev_mahmoud_ashraf.baseapp.data.repositories.PostsRepository
import com.dev_mahmoud_ashraf.baseapp.data.repositories.PostsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dev.mahmoud_ashraf on 12/11/2019.
 */
@Module
class RepositoriesModule {


    @Provides
    @Singleton
    fun provideRepository(remoteServiceDao : RemoteServiceDao): PostsRepository {
        return PostsRepositoryImpl(remoteServiceDao)
    }
}