package com.indialone.broadcastreceiverdemo1.localbroadcastmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LocalBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Local Broadcast Receive called", Toast.LENGTH_SHORT).show()
    }
}