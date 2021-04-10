package com.example.event.bottom_navigation.day

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.event.DateAndPosition
import com.example.event.PagerAdapter
import com.example.event.R
import com.example.event.databinding.FragmentDaysBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

// TODO: Rename parameter arguments, choose names that match
class DaysFragment : Fragment() {
    private lateinit var binding: FragmentDaysBinding
//    private lateinit var pagerAdapterDays: DaysPagerAdapter
//    private lateinit var tabLayoutMediator: TabLayoutMediator

    var week = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_days, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewPager2.adapter = DaysPagerAdapter(this)
        binding.viewPager2.offscreenPageLimit = 1
        binding.viewPager2.setCurrentItem(50, false)

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (DateAndPosition.positionConvertToDate(position).get(Calendar.DAY_OF_WEEK)) {
                1 -> week = "日"
                2 -> week = "一"
                3 -> week = "二"
                4 -> week = "三"
                5 -> week = "四"
                6 -> week = "五"
                7 -> week = "六"
            }
            week += """

                ${DateAndPosition.pTodd(position)}
                """.trimIndent()
            tab.text = week

        }.attach()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Today.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            DaysFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}