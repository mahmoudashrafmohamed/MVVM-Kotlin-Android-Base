package com.dev_mahmoud_ashraf.baseapp


import androidx.browser.customtabs.CustomTabsIntent
import com.dev_mahmoud_ashraf.baseapp.core.activities.BaseToolbarActivity
import javax.inject.Inject
import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : BaseToolbarActivity() {

    @Inject
    lateinit var customTabsIntent: CustomTabsIntent
    lateinit var navOptions: NavOptions


    private val navController by lazy { findNavController(R.id.fragment_activity_main_navigation) }
    private var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view_activity_home)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initNavOptions()
        initNavigation()
    }

    private fun initNavigation() {
        setupActionBarWithNavController(navController)
        bottomNavigationView?.setupWithNavController(navController)
        }

    private fun initNavOptions() {
        navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.anim_slide_in_from_right)
            .setExitAnim(R.anim.anim_slide_out_from_right)
            .setPopEnterAnim(R.anim.anim_slide_in_from_left)
            .setPopExitAnim(R.anim.anim_slide_out_from_left)
            .build()
    }


}
