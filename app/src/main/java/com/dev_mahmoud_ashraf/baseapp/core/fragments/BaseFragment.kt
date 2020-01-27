package com.dev_mahmoud_ashraf.baseapp.core.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import javax.inject.Inject


/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */

@Suppress("UNUSED_PARAMETER")
abstract class BaseFragment : DaggerFragment() {

    protected abstract val layoutId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    // This injection is a workaround for a known issue in Gradle build system https://github.com/google/dagger/issues/955
    @Inject
    fun setDummy(dummy: String) {
        // No impl
    }
}