package com.alankrita.intentexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alankrita.intentexamples.databinding.ActivityMainBinding
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isServiceStarted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvActivity.setOnClickListener {
            startNextActivity()
        }

        binding.tvService.setOnClickListener {
            if(isServiceStarted) stopService()
            else startService()
            isServiceStarted = !isServiceStarted
            updateServiceText()
        }

        binding.tvBroadcast.setOnClickListener {
            startBroadcast()
        }

        binding.tvImplicit.setOnClickListener {
            openMediumPage()
        }

        binding.tvMsg.setOnClickListener {
            shareTextMsg()
        }
    }

    private fun updateServiceText() {
        if(isServiceStarted) binding.tvService.text = "Stop Service"
        else binding.tvService.text = "Start Service"
    }

    private fun startNextActivity() {
        val intent = Intent(this@MainActivity, NextActivity::class.java)
        intent.putExtra("key1", "Wohoo! You successfully opened another activity")
        startActivity(intent)
    }

    private fun startBroadcast() {
        val intent = Intent(this@MainActivity, TestReceiver::class.java)
        sendBroadcast(intent)
    }

    private fun shareTextMsg(){
        val intent = Intent(Intent.ACTION_SEND)
        val content = "Hi From Alankrita!"
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject")
        intent.putExtra(Intent.EXTRA_TEXT, content)
        startActivity(Intent.createChooser(intent, "Share via"))
    }

    private fun openMediumPage(){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://medium.com/@alankrita18.as")
        startActivity(intent)
    }

    private fun startService() {
        startService(Intent(this@MainActivity, TestService::class.java))
    }

    private fun stopService() {
        stopService(Intent(this@MainActivity, TestService::class.java))
    }
}