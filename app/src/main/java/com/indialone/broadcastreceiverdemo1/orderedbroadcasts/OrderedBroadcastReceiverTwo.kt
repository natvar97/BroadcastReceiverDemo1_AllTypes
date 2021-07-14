package com.indialone.broadcastreceiverdemo1.orderedbroadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.widget.Toast

class OrderedBroadcastReceiverTwo : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val handler = Handler(Looper.getMainLooper())
        val pendingResult = goAsync()

        Thread(object : Runnable {
            override fun run() {
                SystemClock.sleep(10000)

                var resultCode = pendingResult.resultCode
                var resultData = pendingResult.resultData
                val resultExtra = pendingResult.getResultExtras(true)

                var stringExtra = resultExtra.getString("stringExtra")

                resultCode++
                stringExtra += "->OBR Two"

                val toastText =
                    "OBR Two\nresult code: $resultCode\nresultData: $resultData\nstring extra: $stringExtra"

                handler.post(object : Runnable {
                    override fun run() {
                        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show()
                    }
                })

                resultData = "OBR Two"
                resultExtra.putString("stringExtra", stringExtra)
                pendingResult.setResult(resultCode, resultData, resultExtra)
                pendingResult.finish()
            }

        }).start()

/*

    ** if you want to use normal ordered broadcast then put it into onReceive() method

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
*/
        // to abort broadcast use below line
//        abortBroadcast()
    }
}