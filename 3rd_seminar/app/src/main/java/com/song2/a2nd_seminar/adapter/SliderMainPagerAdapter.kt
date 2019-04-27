package com.song2.a2nd_seminar.adapter

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.song2.a2nd_seminar.Fragment.SliderMainFragment

class SliderMainPagerAdapter(fm: FragmentManager?,val num_fragment:Int): FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment? {
        var fragment = SliderMainFragment()
        var bundle = Bundle(1)

        when(p0){
            0->bundle.putInt("background_color", Color.RED)
            1->bundle.putInt("background_color", Color.YELLOW)
            2->bundle.putInt("background_color", Color.GREEN)
        }
        fragment.arguments = bundle

        return fragment
    }

    override fun getCount(): Int {
        return num_fragment
    }
}