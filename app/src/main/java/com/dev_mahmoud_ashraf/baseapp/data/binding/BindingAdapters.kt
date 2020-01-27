package com.dev_mahmoud_ashraf.baseapp.data.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
interface BindingAdapters {

    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(url: String?)

    @BindingAdapter("circleImageUrl")
    fun ImageView.setCircleImageUrl(url: String?)

    @BindingAdapter("roundedImageUrl", "radius")
    fun ImageView.setRoundedImageUrl(url: String?, radius: Int)
}