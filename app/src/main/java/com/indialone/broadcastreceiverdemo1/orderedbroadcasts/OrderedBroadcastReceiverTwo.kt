package com.indialone.broadcastreceiverdemo1.orderedbroadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class OrderedBroadcastReceiverTwo : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtra = getResultExtras(true)

        var stringExtra = resultExtra.getString("stringExtra")

        resultCode++
        stringExtra += "->OBR Two"

        val toastText =
            "OBR Two\nresult code: $resultCode\nresultData: $resultData\nstring extra: $stringExtra"

        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show()

        resultData = "OBR Two"
        resultExtra.putString("stringExtra", stringExtra)
        setResult(resultCode, resultData, resultExtra)

        // to abort broadcast use below line
//        abortBroadcast()
    }
}