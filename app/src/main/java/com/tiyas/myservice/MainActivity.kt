package com.tiyas.myservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tiyas.myservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val btnStartService = mainBinding.btnStartService
        btnStartService.setOnClickListener {
            val startServiceIntent = Intent(this, MyService::class.java)
            startService(startServiceIntent)
        }

        val btnStartJobIntentService = mainBinding.btnStartJobIntentService
        btnStartJobIntentService.setOnClickListener {
            val startIntentService = Intent(this, MyIntentService::class.java)
            startIntentService.putExtra(MyIntentService.EXTRA_DURATION, 5000L)
            MyIntentService.enqueueWork(this, startIntentService)
        }

        val btnStartBoundService = mainBinding.btnStartBoundService
        btnStartBoundService.setOnClickListener {

        }

        val btnStopBoundService = mainBinding.btnStopBoundService
        btnStopBoundService.setOnClickListener {

        }


    }
}