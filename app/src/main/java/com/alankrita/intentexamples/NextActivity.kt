package com.alankrita.intentexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alankrita.intentexamples.databinding.ActivityMainBinding
import com.alankrita.intentexamples.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(intent?.hasExtra("key1") == true && intent.getStringExtra("key1") != null)
        binding.tvContent.text = intent.getStringExtra("key1")
    }
}