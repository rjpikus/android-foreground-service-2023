package com.leaf.maythirtyonethree

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
            Log.d(TAG, "Boot completed, starting the service")
            val serviceIntent = Intent(context, MyForegroundService::class.java)
            context.startForegroundService(serviceIntent)
        }
    }

    companion object {
        const val TAG = "MyBroadcastReceiver"
    }
}
