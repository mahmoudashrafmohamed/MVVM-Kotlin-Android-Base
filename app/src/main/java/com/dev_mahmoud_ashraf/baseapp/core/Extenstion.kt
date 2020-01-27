package com.dev_mahmoud_ashraf.baseapp.core

import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Bitmap
import android.util.Base64
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.dev_mahmoud_ashraf.baseapp.R
import kotlinx.android.synthetic.main.dialog_view.view.*
import kotlinx.android.synthetic.main.dialog_view.view.dialogText
import kotlinx.android.synthetic.main.loading.view.*
import java.io.ByteArrayOutputStream
import java.util.*

/**
 * Created by dev.mahmoud_ashraf on 12/13/2019.
 */
fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.showLoadingDialog() : Dialog {
    val view = LayoutInflater.from(this).inflate(R.layout.loading, null)
    val alertDialog = AlertDialog.Builder(this).setView(view).setCancelable(false)
    val dialog = alertDialog.create()
    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    view.loading.loadImage(R.drawable.loading)
    dialog.show()

    return dialog
}

fun Context.showDialog( resID: String, positive:(dialog: AlertDialog?) -> Unit, negative:(dialog: AlertDialog?) -> Unit){
    val view = LayoutInflater.from(this).inflate(R.layout.dialog_view, null)
    val alertDialog = AlertDialog.Builder(this).setView(view).setCancelable(false)
    val dialog = alertDialog.create()
    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    //  view.dialogIcon.setImageResource(drawableRes)
    view.dialogText.text = resID
    view.positiveBtn.setOnClickListener{positive(dialog)}
    //if (drawableRes == R.drawable.dialog_check) view.negativeButton.visibility =View.GONE
    view.negativeButton.setOnClickListener{negative(dialog)}
    dialog.show()
}


fun Context.setLocale( language: String) {

    val activityRes = this.resources
    val activityConf = activityRes.configuration
    val newLocale = Locale(language)
    activityConf.setLocale(newLocale)
    activityRes.updateConfiguration(activityConf, activityRes.displayMetrics)

    val applicationRes =  this.applicationContext.resources
    val applicationConf = applicationRes.configuration
    applicationConf.setLocale(newLocale)
    applicationRes.updateConfiguration(applicationConf, applicationRes.displayMetrics)

    //PrefManager.saveLanguage(language)
}

fun ImageView.loadImage(@DrawableRes drawableRes: Int) {
    Glide.with(this).load(drawableRes).fitCenter().into(this)
}

fun Bitmap.toStringBase(): String {
    val baos = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.PNG, 100, baos)
    val b = baos.toByteArray()
    return Base64.encodeToString(b, Base64.DEFAULT)
}

fun Context.isPortrait() =
    resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

