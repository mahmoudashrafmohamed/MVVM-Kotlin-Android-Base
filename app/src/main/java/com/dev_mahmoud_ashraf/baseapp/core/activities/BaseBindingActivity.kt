package com.dev_mahmoud_ashraf.baseapp.core.activities

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
abstract class BaseBindingActivity : BaseToolbarActivity() {

    private var viewDataBinding: ViewDataBinding? = null

    open fun isBindingEnabled(): Boolean {
        return true
    }

    override fun setContentView(layoutResID: Int) {
        if (isBindingEnabled()) {
            viewDataBinding = DataBindingUtil.setContentView(this, layoutResID)
        } else {
            super.setContentView(layoutResID)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : ViewDataBinding> bind(binding: T?.() -> Unit) {
        binding(viewDataBinding as? T?)
        viewDataBinding?.executePendingBindings()
    }
}