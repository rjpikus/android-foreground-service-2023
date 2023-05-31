package com.leaf.maythirtyonethree

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MyForegroundService : Service() {

    private val serviceScope = CoroutineScope(Dispatchers.IO)

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service is running")
        serviceScope.launch {
            while (isActive) {
                // Perform long running operation here
                Log.d(TAG, "Service is running")
                delay(1000)
            }
        }


        return START_NOT_STICKY
    }

    companion object {
        const val TAG = "MyForegroundService"
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
