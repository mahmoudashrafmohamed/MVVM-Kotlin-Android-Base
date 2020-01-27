package com.dev_mahmoud_ashraf.baseapp.core.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

    abstract fun bind(position: Int)
}