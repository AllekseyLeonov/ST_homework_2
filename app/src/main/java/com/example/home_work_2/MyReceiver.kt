package com.example.home_work_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val powRes = intent.getIntExtra("powRes", 1).toString()
        Toast.makeText(context, "N^N = $powRes", Toast.LENGTH_LONG).show()
        Log.d("LeonovAA", "N^N = $powRes")
    }
}
