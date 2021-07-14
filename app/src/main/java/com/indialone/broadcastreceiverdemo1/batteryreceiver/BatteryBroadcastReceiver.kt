package com.indialone.broadcastreceiverdemo1.batteryreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView

class BatteryBroadcastReceiver(private val tv: TextView) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val percentage = intent?.getIntExtra("level", 0)
        if (percentage != 0) {
            tv.text = "Battery Percentage: $percentage%"
        }
    }
}