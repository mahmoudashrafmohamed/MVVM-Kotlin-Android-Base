package com.dev_mahmoud_ashraf.baseapp.di

import android.content.Context
import com.dev_mahmoud_ashraf.baseapp.MyApplication
import dagger.Binds
import dagger.Module

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideApplication(application: MyApplication): Context
}