package com.indialone.broadcastreceiverdemo1.localbroadcastmanager

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indialone.broadcastreceiverdemo1.R

/*
   it is temporary see the custom_testing repository

    Link: https://github.com/natvar97/custom_testing.git

 */

class LocalBroadcastManagerReceiverActivity : AppCompatActivity() {

    private lateinit var receiver: LocalBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_broadcast_manager_receiver)

        receiver = LocalBroadcastReceiver()

        val intentFilter = IntentFilter("com.indialone.CUSTOM_ACTION")

        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

}