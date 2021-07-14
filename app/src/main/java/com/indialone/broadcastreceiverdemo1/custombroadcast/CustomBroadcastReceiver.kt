package com.indialone.broadcastreceiverdemo1.custombroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if ("com.indialone.CUSTOM_ACTION".equals(intent?.action)) {
            val customText = intent?.getStringExtra("com.indialone.EXTRA_TEXT")
            Toast.makeText(context, customText, Toast.LENGTH_SHORT).show()
        }
    }
}