package com.example.qrcodetest1hori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qrcodetest1hori.databinding.ActivityMainBinding

class MainActivityBackupHor1 : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreate.setOnClickListener {
            val intent = Intent( this, CreateQRActivity::class.java )
            startActivity(intent)
        }

        binding.btnScan.setOnClickListener {
            val intent = Intent( this, ScanQRActivity::class.java )
            startActivity(intent)
        }
    }
}