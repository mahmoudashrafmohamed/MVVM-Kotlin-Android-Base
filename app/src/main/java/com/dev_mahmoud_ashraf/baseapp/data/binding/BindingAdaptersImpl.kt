package com.dev_mahmoud_ashraf.baseapp.data.binding

import android.widget.ImageView
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dev_mahmoud_ashraf.baseapp.data.dpToPx
import com.dev_mahmoud_ashraf.baseapp.data.glide.GlideApp


/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
class BindingAdaptersImpl : BindingAdapters {

    override fun ImageView.setImageUrl(url: String?) {
        GlideApp.with(this).load(url).thumbnail(THUMBNAIL).into(this)
    }

    override fun ImageView.setCircleImageUrl(url: String?) {
        GlideApp.with(this).load(url).thumbnail(THUMBNAIL).apply(RequestOptions.circleCropTransform()).into(this)
    }

    override fun ImageView.setRoundedImageUrl(url: String?, radius: Int) {
        val requestOptions = RequestOptions().transform(CenterCrop(), RoundedCorners(radius.dpToPx(context).toInt()))
        GlideApp.with(this).load(url).thumbnail(THUMBNAIL).apply(requestOptions).into(this)
    }

    private companion object {

        private const val THUMBNAIL = 0.1f
    }
}