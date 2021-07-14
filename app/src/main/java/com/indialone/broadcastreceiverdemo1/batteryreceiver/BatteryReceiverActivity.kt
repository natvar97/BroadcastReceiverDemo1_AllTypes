package com.indialone.broadcastreceiverdemo1.batteryreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.indialone.broadcastreceiverdemo1.R

class BatteryReceiverActivity : AppCompatActivity() {

    private lateinit var receiver: BatteryBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery_receiver)

        val tv = findViewById<TextView>(R.id.tv_battery)
        receiver = BatteryBroadcastReceiver(tv)

        IntentFilter(Intent.ACTION_BATTERY_CHANGED).also {
            registerReceiver(receiver, it)
        }

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

}