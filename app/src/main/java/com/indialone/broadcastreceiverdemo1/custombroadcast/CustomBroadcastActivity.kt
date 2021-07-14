package com.indialone.broadcastreceiverdemo1.custombroadcast

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indialone.broadcastreceiverdemo1.R

/*
    Please see the notes at the end of this class
 */

class CustomBroadcastActivity : AppCompatActivity() {

    private lateinit var receiver: CustomBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_broadcast)

        receiver = CustomBroadcastReceiver()
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(receiver, intentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)

    }

}

/*
    ::IMPORTANT::

    For testing that above custom broadcast is working or not then , go to the below GitHub link
    https://github.com/natvar97/custom_testing.git

    and then clone the project and run both this and project from GitHub and click the button on "custom-testing"
    project then you can see the custom broadcast message but it is only when our this running app is in background
    other wise no message is print on textview in "custom-testing" app

    Thank u.

 */