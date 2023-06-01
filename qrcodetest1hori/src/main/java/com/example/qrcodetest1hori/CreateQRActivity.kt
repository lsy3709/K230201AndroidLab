package com.example.qrcodetest1hori

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.qrcodetest1hori.databinding.ActivityCreateQractivityBinding
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

class CreateQRActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateQractivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateQractivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap("https://www.naver.com/", BarcodeFormat.QR_CODE, 400, 400)
            binding.imageViewQrCode.setImageBitmap(bitmap)
        } catch (e: Exception) {
        }
    }
}