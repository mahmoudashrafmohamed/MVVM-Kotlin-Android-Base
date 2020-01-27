package com.dev_mahmoud_ashraf.baseapp.presentation.home


import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

import com.dev_mahmoud_ashraf.baseapp.R
import com.dev_mahmoud_ashraf.baseapp.core.fragments.BaseFragment
import com.dev_mahmoud_ashraf.baseapp.core.showLoadingDialog
import com.dev_mahmoud_ashraf.baseapp.core.toast
import com.dev_mahmoud_ashraf.baseapp.core.utils.observe
import com.dev_mahmoud_ashraf.baseapp.data.models.PostsResponse
import com.dev_mahmoud_ashraf.baseapp.data.network.Status
import com.dev_mahmoud_ashraf.baseapp.data.prefs.Prefs
import timber.log.Timber
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {

     @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var viewModel: HomeViewModel? = null
    private var dialog : Dialog?= null

    @Inject
    lateinit var prefManager : Prefs

    override val layoutId: Int = R.layout.fragment_home

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(layoutId, container, false)

        val viewPager = root.findViewById(R.id.viewPager) as ViewPager2
        // Important: Must use the child FragmentManager or you will see side effects.
        val sectionsPagerAdapter = SectionsPagerAdapter(activity!!)

        viewPager .apply {
            adapter = sectionsPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        val tabStrip = root.findViewById<TabLayout>(R.id.pagerTabStrip)
        TabLayoutMediator(tabStrip, viewPager, true) { tab, position ->
            tab.text = sectionsPagerAdapter.getPageTitle(position)
        }.attach()


        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[HomeViewModel::class.java]
        viewModel?.validatePostsStateLiveData()?.observe(this){
            (it).getContentIfNotHandled()?.let {
                // Only proceed if the event has never been handled
                when (it.status) {
                    Status.RUNNING -> {
                        dialog = context?.showLoadingDialog()
                    }
                    Status.SUCCESS -> {
                        dialog?.dismiss()
                    }
                    Status.FAILED -> {
                        dialog?.dismiss()
                        context?.toast("" + it.message)
                    }

                }
            }
        }

        viewModel?.validatePostsLiveData()?.observe(this){
            // (it as Event<*>).getContentIfNotHandled()?.let {
            // Only proceed if the event has never been handled

            val data = it as List<PostsResponse>
            context?.toast("data fetched successfully!")
            Timber.e("data= $data")
        }


        getPosts()

    }
    private fun getPosts() {
        viewModel?.getPosts()

    }



    class SectionsPagerAdapter internal constructor(
        private val activity: FragmentActivity
    ) : FragmentStateAdapter(activity) {

        override fun createFragment(position: Int): Fragment {
            val args = Bundle().apply { putInt(ChildFragment.POSITION_KEY, position) }
         return   ChildFragment.newInstance(args)
        }

        fun getPageTitle(position: Int): CharSequence =
            "Tab $position"

        override fun getItemCount(): Int = 2


        }
    companion object {
        val TAG: String = HomeFragment::class.java.name
    }

}
