package com.dev_mahmoud_ashraf.baseapp.core.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
abstract class BaseBindingFragment : BaseFragment() {

    private var viewDataBinding: ViewDataBinding? = null

    open fun isBindingEnabled(): Boolean {
        return true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View?
        if (isBindingEnabled()) {
            viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
            view = viewDataBinding?.root
        } else {
            view = super.onCreateView(inflater, container, savedInstanceState)
        }
        return view
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : ViewDataBinding> bind(binding: T?.() -> Unit) {
        binding(viewDataBinding as? T?)
        viewDataBinding?.executePendingBindings()
    }
}