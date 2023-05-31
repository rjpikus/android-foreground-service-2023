package com.leaf.maythirtyonethree

import com.leaf.maythirtyonethree.MyForegroundService
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import android.content.Context
import android.app.ActivityManager
import com.leaf.maythirtyonethree.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!isMyServiceRunning(MyForegroundService::class.java)) {
            Log.d(TAG, "Service is not running, starting it now")
            val serviceIntent = Intent(this, MyForegroundService::class.java)
            startForegroundService(serviceIntent)
        } else {
            Log.d(TAG, "Service is already running")
        }
    }

    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
