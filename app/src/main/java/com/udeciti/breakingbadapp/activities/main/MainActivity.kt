package com.udeciti.breakingbadapp.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.udeciti.breakingbadapp.R
import com.udeciti.breakingbadapp.databinding.ActivityMainBinding
import com.udeciti.breakingbadapp.fragments.CharactersFragment
import com.udeciti.breakingbadapp.fragments.PhraseFragment
import com.udeciti.breakingbadapp.fragments.SettingsFragment
import com.udeciti.breakingbadapp.fragments.adapters.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    companion object{
        const val EMAIL_KEY = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val fragments = mutableListOf<Fragment>(
            CharactersFragment(),
            PhraseFragment(),
            SettingsFragment()
        )
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle, fragments)

        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager){
            tab, position ->
            when(position){
                0 -> tab.text = "Characters"
                1 -> tab.text = "Phrase"
                2 -> tab.text = "Settings"
            }
        }.attach()

    }
}