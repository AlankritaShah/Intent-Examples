package com.alankrita.intentexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alankrita.intentexamples.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvActivity.setOnClickListener {
            startNextActivity()
        }
    }

    private fun startNextActivity() {
        val intent = Intent(this@MainActivity, NextActivity::class.java)
        intent.putExtra("key1", "Wohoo! You successfully opened another activity")
        startActivity(intent)
    }
}