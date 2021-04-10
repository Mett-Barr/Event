package com.example.event.bottom_navigation

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.event.bottom_navigation.day.BlankFragment
import com.example.event.bottom_navigation.day.DaysFragment

class MainPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return BlankFragment()
            1 -> return DaysFragment()
            2 -> return BlankFragment()
        }

        return BlankFragment()
    }
}