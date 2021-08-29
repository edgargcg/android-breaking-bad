package com.udeciti.breakingbadapp.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.udeciti.breakingbadapp.R
import com.udeciti.breakingbadapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val EMAIL_KEY = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


    }
}