package com.dev_mahmoud_ashraf.baseapp

import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import com.dev_mahmoud_ashraf.baseapp.data.binding.BindingAdapters
import com.dev_mahmoud_ashraf.baseapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import javax.inject.Inject
/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */

class MyApplication : DaggerApplication() {

    @Inject
    lateinit var bindingAdapters: BindingAdapters

    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(object : DataBindingComponent {

            override fun getBindingAdapters(): BindingAdapters {
                return this@MyApplication.bindingAdapters
            }
        })
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
            .apply {
                inject(this@MyApplication)
            }
    }
}