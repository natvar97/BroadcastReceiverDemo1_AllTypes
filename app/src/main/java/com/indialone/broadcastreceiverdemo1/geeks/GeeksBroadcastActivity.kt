package com.indialone.broadcastreceiverdemo1.geeks

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.indialone.broadcastreceiverdemo1.R

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
class GeeksBroadcastActivity : AppCompatActivity() {

    private lateinit var receiver: AirplaneModeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geeks_broadcast)

        receiver = AirplaneModeChangeReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(receiver)
    }

}