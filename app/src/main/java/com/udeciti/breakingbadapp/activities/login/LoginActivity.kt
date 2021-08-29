package com.udeciti.breakingbadapp.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.udeciti.breakingbadapp.R
import com.udeciti.breakingbadapp.activities.main.MainActivity
import com.udeciti.breakingbadapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)

        val email = binding.email.text
        val password = binding.password.text

        binding.loginButton.setOnClickListener(){
            if (
                email.isEmpty()
                ||
                password.isEmpty()
            ){
                Toast.makeText(this, "Please type your email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}