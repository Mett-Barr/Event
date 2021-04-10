package com.example.event.bottom_navigation.day

import android.content.ContentValues.TAG
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.*

class DaysPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    var mDailyFragments = ArrayList<DailyFragment>()

    override fun getItemCount(): Int = 101

    override fun createFragment(position: Int): Fragment {
        Log.d(TAG, "createFragment: ")
//        val blankFragment = BlankFragment()
//        return blankFragment
        return DailyFragment(position, this)
    }
}