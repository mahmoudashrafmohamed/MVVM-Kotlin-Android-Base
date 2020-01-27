package com.dev_mahmoud_ashraf.baseapp.core.custom

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.TextViewCompat
import com.dev_mahmoud_ashraf.baseapp.R

/**
 * Created by dev.mahmoud_ashraf on 12/12/2019.
 */
class CenteredToolbar(context: Context, attributeSet: AttributeSet) :
    Toolbar(context, attributeSet) {
    private var centeredTitleTextView: TextView? = null

    override fun setTitle(title: CharSequence) {
        getCenteredTitleTextView().text = title
    }

    override fun getTitle(): CharSequence {
        return getCenteredTitleTextView().text.toString()
    }

    private fun getCenteredTitleTextView(): TextView {
        if (centeredTitleTextView == null) {
            centeredTitleTextView = TextView(context)
            centeredTitleTextView?.let {
                with(it) {
                    setSingleLine()
                    ellipsize = TextUtils.TruncateAt.END
                    gravity = Gravity.CENTER

                    val textStyle = R.style.TextAppearance_AppCompat_Widget_ActionBar_Title
                    TextViewCompat.setTextAppearance(it, textStyle)
                    val params = Toolbar.LayoutParams(
                        Toolbar.LayoutParams.WRAP_CONTENT,
                        Toolbar.LayoutParams.WRAP_CONTENT
                    )
                    params.gravity = Gravity.CENTER
                    layoutParams = params
                    addView(centeredTitleTextView)
                }
            }
        }
        return centeredTitleTextView as TextView
    }
}