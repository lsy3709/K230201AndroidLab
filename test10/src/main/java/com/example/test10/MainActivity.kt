package com.example.test10

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.MediaController
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.test10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //경고창 다이얼 로그에서, 확인시 수행하는 기능을 추가시
    // DialogInterface.OnClickListener 구현한 함수가 필요함.
    // 그래서, 따로 만들어서 , 설정.
    val eventHandler = object : DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            if(which == DialogInterface.BUTTON_POSITIVE) {
                Toast.makeText(this@MainActivity,"확인시 토스트 띄우기",Toast.LENGTH_SHORT).show()
            } else if(which == DialogInterface.BUTTON_NEGATIVE) {
                Toast.makeText(this@MainActivity,"취소시 토스트 띄우기",Toast.LENGTH_SHORT).show()
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.R)
    fun showTest() {
        val toast = Toast.makeText(this,"메세지 내용",Toast.LENGTH_SHORT)
        toast.addCallback(
            object : Toast.Callback() {
                override fun onToastHidden() {
                    super.onToastHidden()
                    Log.d("lsy", "toast hidden , 숨겨진 후 추가 기능 동작. ")
                }

                override fun onToastShown() {
                    super.onToastShown()
                    Log.d("lsy", "toast shown , 보여진 후 추가 기능 동작. ")
                }
            }
        )
        toast.show()
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //샘플 영상 확인 작업.
        binding.btnVideo.setOnClickListener {
            val videofile:Uri = Uri.parse("android.resource://"+packageName+"/raw/testvideo")

//            val player: MediaPlayer = MediaPlayer.create(this@MainActivity,R.raw.testvideo)
//            player.start()
            val mc = MediaController(this) // 비디오 컨트롤 가능하게(일시정지, 재시작 등)

            binding.videoView.setMediaController(mc)
            binding.videoView.setVideoPath(videofile.toString()) // 선택한 비디오 경로 비디오뷰에 셋
            binding.videoView.start() // 비디오뷰 시작

//            binding.VideoImage2.setVideoURI(uri)
//// 비디오 뷰 테스트
//            binding.VideoImage2.setOnPreparedListener {
//                    mp -> // 준비 완료되면 비디오 재생
//                mp.start()
//            }
        }


        //소리 부분 확인 작업.
        binding.btnSound.setOnClickListener {
            val notification : Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone = RingtoneManager.getRingtone(applicationContext, notification)
            ringtone.play()
        }

        // 다이얼로그에 체크박스 선택 부분 해보기.
        binding.btnCheck.setOnClickListener {
            val items = arrayOf<String>("두루치기","된장찌개","밀면","칼국수")
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("checkbox alert 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true,false,false,false),
                    object : DialogInterface.OnMultiChoiceClickListener{
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                            Log.d("lsy",
                                "선택한 점심 메뉴 : ${items[which]} 이 ${if(isChecked)"선택됨."
                                else "선택 해제됨."}"
                                        )
                        }
                    }
                )
                setPositiveButton("닫기",null)
                setCancelable(true)
                show()
            }.setCanceledOnTouchOutside(true)
        }

        // 다이얼로그에 메뉴 선택 부분 확인 해보기.
        binding.btnMenu.setOnClickListener {
            val items = arrayOf<String>("두루치기","된장찌개","밀면","칼국수")
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("메뉴 alert 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setItems(
                    items,
                    object: DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Log.d("lsy","선택한 점심 메뉴 : ${items[which]}")
                        }
                    }
                )
                setPositiveButton("닫기",null)
                show()
            }
        }


        // 경고창, 특정 정보를 띄워서, 확인시 동작 기능, 취소시 동작.
        // 설정한 eventHandler 변수에 담긴 , 익명 함수를 사용함.
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("테스트 제목")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("토스트 메시지 띄울까요?")
                setPositiveButton("확인",eventHandler)
                setNegativeButton("취소",eventHandler)
                show()
            }
        }

        // 시간 다이어로그 띄우기.
        binding.btnTime.setOnClickListener {
            //TimePickerDialog(this,익명클래스,시간,분, 24시 표시여부).show()
            TimePickerDialog(this,object: TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Log.d("lsy","hourOfDay(시간): ${hourOfDay}시,minute: ${minute}분 ")
                }
            }, 15,10,true).show()
        }

        //날짜 다이어로그 띄우기, 출력은 , 콘솔 또는 토스트 메세지
        binding.btnDate.setOnClickListener {
            //DatePickerDialog(this, 리스너, 년도,월,일).show
            DatePickerDialog(this,object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Log.d("lsy","year(년도): $year, month: ${month+1}, dayOfMonth : $dayOfMonth")
                    //토스트에 해당 날짜 띄워보기.
                    Toast.makeText(this@MainActivity,
                        "year(년도): $year, month: ${month+1}, dayOfMonth : $dayOfMonth"
                    ,Toast.LENGTH_SHORT).show()
                }
            }, 2020,5,15).show()
        }

        //시간을 띄우는 버튼 UI 추가,
        // 해당 시간을 출력하는 , 1)Log.d 2) 토스트 메시지에도 출력하기.
        //pdf 18 페이지 코드 참고.


        // 방법1
//        val toast = Toast.makeText(this,"메세지 내용",Toast.LENGTH_SHORT)

        binding.btn1.setOnClickListener {
            //toast.show()
            //방법2
            //Toast.makeText(this,"토스트 출력 방법2",Toast.LENGTH_SHORT).show()

            //옵션, 토스트 메세지가 보여지거나, 사라졌을 경우에 추가 기능을 확인중.
            showTest()
        }



//        val requestPermissionLauncher = registerForActivityResult(
//            ActivityResultContracts.RequestPermission()
//        ){
//            isGranted ->
//            if(isGranted) {
//                Log.d("lsy","승인됨.")
//            } else {
//                Log.d("lsy","승인 안됨.")
//            }
//        }
//
//        val status = ContextCompat.checkSelfPermission(this,"android.permission.ACCESS_FINE_LOCATION")
//        if(status == PackageManager.PERMISSION_GRANTED){
//            Log.d("lsy","status 승인 됨2.")
//        } else {
//            requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
//        }

    }
}