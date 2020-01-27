package com.dev_mahmoud_ashraf.baseapp.data

import android.content.Context
import android.util.TypedValue

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */

fun Int.dpToPx(context: Context?): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context?.resources?.displayMetrics)
}