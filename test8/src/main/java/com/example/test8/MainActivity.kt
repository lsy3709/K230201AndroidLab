package com.example.test8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import com.example.test8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode) {
            KeyEvent.KEYCODE_BACK -> Log.d("lsy","백키 누름")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("lsy","볼륨업 누름")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("lsy","볼륨 다운 누름")
        }
//        Log.d("lsy","onKeyDown 실행")
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("lsy","onKeyUp 실행")
        return super.onKeyUp(keyCode, event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("lsy","좌표 x : ${event.x} , rawX 좌표 : ${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("lsy","Touch up evet 발생함. ")
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)



    }
}