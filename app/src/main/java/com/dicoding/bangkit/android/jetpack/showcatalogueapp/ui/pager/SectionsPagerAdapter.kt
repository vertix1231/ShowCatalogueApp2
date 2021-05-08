package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.pager

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.R
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.fragmentui.MovieFragment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.fragmentui.TvShowFragment

class SectionsPagerAdapter (private val context: Context,fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_title_movie, R.string.tab_title_tvshow)
    }
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> MovieFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }
        return Fragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        context.resources.getString(TAB_TITLES[position])
        return super.getPageTitle(position)
    }
}