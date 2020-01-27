package com.dev_mahmoud_ashraf.baseapp.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.room.Room
import com.dev_mahmoud_ashraf.baseapp.R
import com.dev_mahmoud_ashraf.baseapp.data.binding.BindingAdapters
import com.dev_mahmoud_ashraf.baseapp.data.binding.BindingAdaptersImpl
import com.dev_mahmoud_ashraf.baseapp.data.coroutines.CoroutinesContextProvider
import com.dev_mahmoud_ashraf.baseapp.data.coroutines.CoroutinesContextProviderImpl
import com.dev_mahmoud_ashraf.baseapp.data.database.Database
import com.dev_mahmoud_ashraf.baseapp.data.prefs.Prefs
import com.dev_mahmoud_ashraf.baseapp.data.prefs.PrefsImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
@Module
object CommonModule {

    private const val SHARED_PREFERENCES_NAME = "com.dev_mahmoud_ashraf.baseapp"
    private const val DATABASE_NAME = "postsdb"

    // This injection is a workaround for a known issue in Gradle build system https://github.com/google/dagger/issues/955
    @Provides
    @Singleton
    fun provideDummyObject(): String {
        return ""
    }

    @Provides
    @Singleton
    fun provideContextProvider(): CoroutinesContextProvider {
        return CoroutinesContextProviderImpl()
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Application): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePrefs(sharedPreferences: SharedPreferences): Prefs {
        return PrefsImpl(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideBindingAdapters(): BindingAdapters {
        return BindingAdaptersImpl()
    }

    @Provides
    @Singleton
    fun provideCustomTabsIntent(context: Application): CustomTabsIntent {
        return CustomTabsIntent.Builder()
            .setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
            .build()
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Application): Database {
        return Room.databaseBuilder(context, Database::class.java, DATABASE_NAME).build()
    }
}