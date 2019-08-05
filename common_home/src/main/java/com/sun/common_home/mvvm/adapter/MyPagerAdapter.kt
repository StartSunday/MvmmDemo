package com.sun.common_home.mvvm.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @作者 ${yongming}
 * @创建日期 2019/8/2 14:33
 * @说明
 */
class MyPagerAdapter constructor(fm: FragmentManager, var mfragments: ArrayList<Fragment>): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return mfragments[position]
    }

    override fun getCount(): Int {
        return  mfragments.size
    }
}