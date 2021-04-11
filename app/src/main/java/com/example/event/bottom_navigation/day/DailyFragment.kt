package com.example.event.bottom_navigation.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.event.R
import com.example.event.databinding.FragmentDailyBinding

// TODO: Rename parameter arguments, choose names that match
class DailyFragment(_position: Int, _daysPagerAdapter: DaysPagerAdapter) : Fragment() {
    private lateinit var binding: FragmentDailyBinding

    private val position = _position
    private val daysPagerAdapter = _daysPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_daily, container, false)
        binding.textView.text = position.toString()

        return inflater.inflate(R.layout.fragment_daily, container, false)
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment Today.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(position: Int) =
//            DailyFragment().apply {
//                this.position = position
////                }
//            }
//    }



    //更新事件
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        daysPagerAdapter.mDailyFragments.add(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        daysPagerAdapter.mDailyFragments.remove(this)
    }

//    override fun onResume() {
//        super.onResume()
//        mAdapter.dataChange()
//    }
}