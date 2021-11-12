package com.tiyas.myservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log

class MyBoundService : Service() {

    companion object {
        private val TAG = MyBoundService::class.java.simpleName
    }

    private  var mBinder = MyBinder()
    private val startTime = System.currentTimeMillis()

    internal  inner  class MyBinder : Binder() {
        val getService : MyBoundService = this@MyBoundService
    }

//     membuat time count down
    private var mTimer : CountDownTimer = object : CountDownTimer(100000, 1000){
    override fun onTick(l: Long) {
        val elapsedTime = System.currentTimeMillis() - startTime
        Log.d(TAG, "onTick : $elapsedTime")
    }

    override fun onFinish() {

    }
    }


    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}