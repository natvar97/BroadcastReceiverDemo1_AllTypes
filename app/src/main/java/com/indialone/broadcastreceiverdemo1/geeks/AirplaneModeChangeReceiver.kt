package com.indialone.broadcastreceiverdemo1.geeks

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
class AirplaneModeChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (isAirplaneModeOn(context!!))
            Toast.makeText(context, "Airplane mode is on!", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Airplane mode is off!", Toast.LENGTH_SHORT).show()

    }


    private fun isAirplaneModeOn(context: Context): Boolean {
        return Settings.System.getInt(
            context.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON,
            0
        ) != 0
    }

}