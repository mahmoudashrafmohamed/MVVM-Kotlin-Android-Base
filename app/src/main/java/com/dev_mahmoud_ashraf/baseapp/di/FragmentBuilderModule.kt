package com.dev_mahmoud_ashraf.baseapp.di

import com.dev_mahmoud_ashraf.baseapp.presentation.cart.CartFragment
import com.dev_mahmoud_ashraf.baseapp.presentation.home.ChildFragment
import com.dev_mahmoud_ashraf.baseapp.presentation.home.HomeFragment
import com.dev_mahmoud_ashraf.baseapp.presentation.more.MoreFragment
import com.dev_mahmoud_ashraf.baseapp.presentation.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
/*(modules = [LatestIssueFragmentModule::class])*/
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun bindMoreFragment(): MoreFragment

    @ContributesAndroidInjector
    abstract fun binCartFragment(): CartFragment

    @ContributesAndroidInjector
    abstract fun binChildFragment(): ChildFragment





}