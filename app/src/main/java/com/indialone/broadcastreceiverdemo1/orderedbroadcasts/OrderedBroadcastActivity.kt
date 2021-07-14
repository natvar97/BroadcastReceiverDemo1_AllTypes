package com.indialone.broadcastreceiverdemo1.orderedbroadcasts

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indialone.broadcastreceiverdemo1.R

class OrderedBroadcastActivity : AppCompatActivity() {

    private lateinit var receiverOne: OrderedBroadcastReceiverOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordered_broadcast)

        receiverOne = OrderedBroadcastReceiverOne()

        val intentFilter = IntentFilter("com.indialone.CUSTOM_ACTION")
        /*
            we can set priority to intent filter in manifest for OrderBroadcastReceiver Two and Three
            and for One we can make it here
            intentFilter.setPriority(yourchoice)

            ::Priority::
            higher number has priority first and it will between -1000 to 1000 in Integer

         */
        registerReceiver(receiverOne, intentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiverOne)
    }

}

/*
        ::NOTES::

        if we define permission for OrderBroadcast receivers or we make our custom permission and pass it to
        particular receiver then on other app which we use for sender app then it should be contains all the permissions
        that we given to the receivers of the receiver app.

        Otherwise we sender app can't get the receiver app's receivers

 */