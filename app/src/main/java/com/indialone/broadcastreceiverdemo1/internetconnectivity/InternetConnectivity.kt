package com.indialone.broadcastreceiverdemo1.internetconnectivity

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indialone.broadcastreceiverdemo1.R

class InternetConnectivity : AppCompatActivity() {

    private lateinit var receiver: InternetConnectivityBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_connectivity)

        receiver = InternetConnectivityBroadcastReceiver()

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
//        intentFilter.addAction(packageName + "android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(receiver, intentFilter)


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

}