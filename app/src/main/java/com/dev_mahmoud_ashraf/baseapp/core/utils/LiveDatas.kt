package com.dev_mahmoud_ashraf.baseapp.core.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline callback: (T) -> Unit) {
    observe(owner, Observer { callback(it) })
}