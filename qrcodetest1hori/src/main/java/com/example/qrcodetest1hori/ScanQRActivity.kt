package com.example.qrcodetest1hori

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.qrcodetest1hori.databinding.ActivityScanQractivityBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class ScanQRActivity : AppCompatActivity() {
    lateinit var binding: ActivityScanQractivityBinding

    // 스캐너 설정
    private val barcodeLauncher = registerForActivityResult(
        ScanContract()
    ) { result: ScanIntentResult ->
        // result : 스캔된 결과

        // 내용이 없다면
        if (result.contents == null) {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
        }
        else { // 내용이 있다면

            // 1. Toast 메시지 출력.
            Toast.makeText(
                this,
                "Scanned: " + result.contents,
                Toast.LENGTH_LONG
            ).show()

            // 2. 결과 값 TextView에 출력.
            binding.txtResult.text = result.contents.toString()
        }
    }

    fun onScanButtonClicked() {
        // Launch ( SCAN 실행 )
        //기존 가로 방향 설정.
//        barcodeLauncher.launch(ScanOptions())

        // 세로 방향 옵션
        val options = ScanOptions()
        options.setOrientationLocked(false)     // ScanOption 의 Orientation Lock 을 해제하기.
        barcodeLauncher.launch(options)         // Orientation Lock 을 해제한 상태로 실행.

    }

    // 커스텀 스캐너 실행하기
    // Custom SCAN - onClick
    private fun onCustomScanButtonClicked() {
        // Custom Scan Layout -> Activity

        // Intent ? -> 맞는 방법일까 ?
        // val intent = Intent( this, CustomBarcodeScannerActivity::class.java)
        // startActivity(intent)

        // ScanOptions + captureActivity(CustomScannerActivity)
        val options = ScanOptions()
        options.setOrientationLocked(false)
        // options.setCameraId(1)          // 0 : 후면(default), 1 : 전면,
        options.setBeepEnabled(true)
        // options.setTorchEnabled(true)      // true : 실행되자마자 플래시가 켜진다.
        options.setPrompt("커스텀 QR 스캐너 창")
        options.setDesiredBarcodeFormats( ScanOptions.QR_CODE )
        options.captureActivity = CustomBarcodeScannerActivity::class.java

        barcodeLauncher.launch(options)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanQractivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        txtResult = findViewById(R.id.txtResult)

        // SCAN 버튼 클릭
        binding.btnScan.setOnClickListener {
            onScanButtonClicked()
        }

        // Custom Scan 버튼 클릭
        binding.btnCustomScan.setOnClickListener {
            onCustomScanButtonClicked()
        }
    }
}