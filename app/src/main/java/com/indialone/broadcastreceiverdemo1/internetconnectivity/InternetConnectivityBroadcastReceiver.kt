package com.indialone.broadcastreceiverdemo1.internetconnectivity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class InternetConnectivityBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        /*
            no need of boot complete it
            if (Intent.ACTION_BOOT_COMPLETED.equals(intent?.action)) {
                Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show()
            }

         */

        // api level 26 and higher connectivity not working if we define it in AndroidManifest.xml file
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent?.action)) {
            val noConnectivity : Boolean = intent!!.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
            if (noConnectivity) Toast.makeText(context, "Internet Disconnected", Toast.LENGTH_SHORT).show()
            else Toast.makeText(context, "Internet Connected", Toast.LENGTH_SHORT).show()
        }
    }
}