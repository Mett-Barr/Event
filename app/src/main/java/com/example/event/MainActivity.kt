package com.example.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.event.bottom_navigation.MainPagerAdapter
import com.example.event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewPager2.adapter = MainPagerAdapter(this)
        binding.viewPager2.setCurrentItem(1, false)
        binding.viewPager2.isUserInputEnabled = false
    }
}