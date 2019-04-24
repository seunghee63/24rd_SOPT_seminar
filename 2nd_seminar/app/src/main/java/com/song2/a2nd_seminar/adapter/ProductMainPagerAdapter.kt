package com.song2.a2nd_seminar.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.song2.a2nd_seminar.Fragment.AllProductMainFragment
import com.song2.a2nd_seminar.Fragment.EndProductMainFragment
import com.song2.a2nd_seminar.Fragment.NewProductMainFragment

class ProductMainPagerAdapter(fm: FragmentManager?, private val fragment_num : Int): FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment? { //?는 널값을 리턴하기도한다는 뜻
        return when (p0){
            0->AllProductMainFragment()
            1->NewProductMainFragment()
            2->EndProductMainFragment()

            else -> null
        }
    }

    override fun getCount(): Int {
        return fragment_num
    }


}