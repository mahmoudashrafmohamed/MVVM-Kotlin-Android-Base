package com.dev_mahmoud_ashraf.baseapp.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev_mahmoud_ashraf.baseapp.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,MainActivity::class.java))

        finish()
    }

    override fun onBackPressed() {
        // No impl
    }
}
