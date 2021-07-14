package com.indialone.broadcastreceiverdemo1.vogella

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.indialone.broadcastreceiverdemo1.R

class VogellaActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var etTime: EditText

    private lateinit var receiver: OwnPhoneReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vogella)

        button = findViewById(R.id.button)
        etTime = findViewById(R.id.time)

        receiver = OwnPhoneReceiver()

        button.setOnClickListener {
            startAlert()
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(packageName+"android.intent.action.PHONE_STATE")
        registerReceiver(receiver ,intentFilter)

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)

    }

    private fun startAlert() {
        val i: Int = etTime.text.toString().toInt()

        val intent = Intent(this, MyBroadCastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 942995778, intent, 0)

        val alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(
            AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent
        )
        Toast.makeText(this, "Alarm is set to $i seconds", Toast.LENGTH_SHORT).show()
    }

    private fun broadCastIntent() {
        val intent = Intent(this, OwnPhoneReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1234, intent, 0)

    }

}