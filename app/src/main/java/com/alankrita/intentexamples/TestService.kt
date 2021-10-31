package com.alankrita.intentexamples

import android.app.Service
import android.widget.Toast
import android.content.Intent
import android.os.IBinder
import androidx.annotation.Nullable

class TestService : Service() {
    @Nullable
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Start of service", Toast.LENGTH_LONG).show()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "End of Service", Toast.LENGTH_LONG).show()
    }
}