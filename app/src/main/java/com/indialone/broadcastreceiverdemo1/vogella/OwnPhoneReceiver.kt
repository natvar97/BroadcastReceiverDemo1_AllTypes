package com.indialone.broadcastreceiverdemo1.vogella

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log

class OwnPhoneReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.extras != null) {
            val state = intent.extras?.getString(TelephonyManager.EXTRA_STATE)
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                val phoneNumber = intent.extras?.getString(TelephonyManager.EXTRA_INCOMING_NUMBER)
                Log.e("MYPhoneReceiver", "$phoneNumber")
            }
        }
    }

}