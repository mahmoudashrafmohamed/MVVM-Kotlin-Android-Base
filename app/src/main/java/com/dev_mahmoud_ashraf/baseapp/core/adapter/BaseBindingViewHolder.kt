package com.dev_mahmoud_ashraf.baseapp.core.adapter

import androidx.databinding.ViewDataBinding

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
abstract class BaseBindingViewHolder(viewDataBinding: ViewDataBinding) : BaseViewHolder(viewDataBinding.root) {

    var viewDataBinding: ViewDataBinding? = viewDataBinding

    @Suppress("UNCHECKED_CAST")
    inline fun <T : ViewDataBinding> bind(binding: T.() -> Unit) {
        binding(viewDataBinding as T)
        viewDataBinding?.executePendingBindings()
    }


}