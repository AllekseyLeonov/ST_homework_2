package com.example.home_work_2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.pow

class PowService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val n = intent!!.getIntExtra("N", 1)
        pow(n)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun pow(n: Int) {
        var res : Int
        GlobalScope.launch {
           res = n.toDouble().pow(n.toDouble()).toInt()
            sendMassage(res)
            stopSelf()
        }
    }

    private fun sendMassage(integer :Int){
        val powIntent = Intent()
        powIntent.action = "POW_CALCULATED"
        powIntent.putExtra("powRes", integer)
        sendBroadcast(powIntent)
    }

}
