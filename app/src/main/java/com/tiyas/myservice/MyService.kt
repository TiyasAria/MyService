package com.tiyas.myservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*
import java.lang.UnsupportedOperationException

class MyService : Service() {

    companion object {
        internal  val TAG = MyService::class.java.simpleName
    }

    private val serviceJob = Job()
    private val serviceScope = CoroutineScope(
        Dispatchers.Main + serviceJob
    )

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet Implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service dijalankan")
        serviceScope.launch {
            delay(3000)
            stopSelf()
            Log.d(TAG, "service di heentikan")
        }
        return  START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceJob.cancel()
        Log.d(TAG,"onDestroy : ")
    }
}