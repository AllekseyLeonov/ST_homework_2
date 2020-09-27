package com.example.home_work_2

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var activityCounter : Int = 0;
    private val TAG = "LeonovAA"
    private val activityCounterKEY = "ACTIVITY_COUNTER"
    private val br = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(activityCounterKEY, activityCounter)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        activityCounter = savedInstanceState.getInt(activityCounterKEY)
        activityCounter++
        Log.w(TAG,"Activity was restored $activityCounter times (N = $activityCounter)")
        n_textView.text = "N = $activityCounter"
        startService(Intent(this, PowService::class.java).putExtra("N", activityCounter))
    }
    override fun onStart() {
        super.onStart()
        registerReceiver(br, IntentFilter("POW_CALCULATED"))
    }
    override fun onStop() {
        unregisterReceiver(br)
        super.onStop()
    }
}