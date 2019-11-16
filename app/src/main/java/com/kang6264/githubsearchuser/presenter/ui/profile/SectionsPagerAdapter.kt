package com.kang6264.githubsearchuser.presenter.ui.profile

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kang6264.githubsearchuser.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

class SectionsPagerAdapter(private val context: Context, fm:FragmentManager,
                           val login : String?) : FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return OverViewFragment.newInstance(login)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 1
    }
}