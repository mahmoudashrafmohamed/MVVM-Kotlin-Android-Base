package com.dev_mahmoud_ashraf.baseapp.data.prefs

import android.content.SharedPreferences

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */
class PrefsImpl(private val sharedPreferences: SharedPreferences) : Prefs {
    override var lang: String
        get() =  sharedPreferences.getString(LANGUAGE, "en") ?: "en"
        set(value) {
            sharedPreferences.edit().putString(LANGUAGE, value).apply()
        }

    override var isFingerprintActivated: Boolean
        get() = sharedPreferences.getBoolean(IS_FINGERPRINT_ACTIVATED, false)
        set(value) {
            sharedPreferences.edit().putBoolean(IS_FINGERPRINT_ACTIVATED, value).apply()
        }

    companion object {

        const val IS_FINGERPRINT_ACTIVATED = "isFingerprintActivated"
        const val LANGUAGE = "lang"
    }
}