package com.example.myfrag1

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myfragment.fragment_second
import fragment_first

class ViewPagerAdapter(private val mContext: Context, fm:
FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            fragment_first.newInstance()
        } else {
            fragment_second.newInstance()
        }
    }
    override fun getPageTitle(position: Int): CharSequence? { return mContext.resources.getString(TAB_TITLES[position])
    }
    override fun getCount(): Int {
        return 2
    }
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_text_1, R.string.tab_text_2)

    }
}