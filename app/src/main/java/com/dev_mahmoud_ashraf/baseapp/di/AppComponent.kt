package com.dev_mahmoud_ashraf.baseapp.di

import android.app.Application
import com.dev_mahmoud_ashraf.baseapp.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        RepositoriesModule::class,
        DaosModule::class,
        CommonModule::class,
        FragmentBuilderModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    override fun inject(instance: MyApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}