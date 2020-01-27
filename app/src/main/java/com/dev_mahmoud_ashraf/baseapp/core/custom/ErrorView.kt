package com.dev_mahmoud_ashraf.baseapp.core.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import com.dev_mahmoud_ashraf.baseapp.R
import com.dev_mahmoud_ashraf.baseapp.data.network.NetworkState

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
class ErrorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var retryListener: (() -> Unit)? = null

    private var textViewMessage: TextView?  = null
    private var textViewTitle: TextView? = null
    private var buttonRetry: Button? = null

    init {
        View.inflate(context, R.layout.view_error, this)
        textViewMessage =  findViewById(R.id.text_view_error_message)
        textViewTitle= findViewById(R.id.text_view_error_title)
        buttonRetry = findViewById(R.id.button_view_error_retry)
        visibility = View.GONE

        buttonRetry?.setOnClickListener {
            retryListener?.invoke()
            visibility = View.GONE
        }
    }

    fun setError(error: NetworkState) {
        visibility = View.VISIBLE
        textViewMessage?.setText(error.message)
       // textViewTitle?.setText(error.error.resourceTitle)
    }

    fun setOnRetryClickListener(listener: (() -> Unit)?) {
        this.retryListener = listener
    }
}