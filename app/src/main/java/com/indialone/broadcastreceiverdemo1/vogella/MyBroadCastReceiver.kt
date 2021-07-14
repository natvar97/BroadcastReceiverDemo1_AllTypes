package com.indialone.broadcastreceiverdemo1.vogella

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Vibrator
import android.widget.Toast

class MyBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Don't panic but your time is up!!", Toast.LENGTH_SHORT).show()

        val vibrate: Vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrate.vibrate(2000)

    }
}