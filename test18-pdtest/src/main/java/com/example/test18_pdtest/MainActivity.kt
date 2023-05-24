package com.example.test18_pdtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test18_pdtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    //공공데이터 API
    // 부산맛집정보 서비스
    // 가입 후, 로그인 , 해당 요청 정보에서, API 키 발급 신청.
    // 하루 만 사용가능한 키 바로 발급됨.
    // API 문서 다운로드 받기.
    // 참고할 샘플 코드 : test18 : reqres.in
    // build.gradle 파일 ,
    // 1)뷰 바인딩 2) 레트로핏 3) gson 4) gson-converter 5) Glide
    // test18 있는 전체 코드(MainActivity3)를 다 복사.
    // 변경할 사항
    // 1) 모델 클래스(리스트포함)
    // 2) baseUrl 주소 및 서버에 전달하는 파라미터 확인.
    // 3) 인터페이스에 정의된 함수의 매개변수 확인.
    // 4) 뷰 의 틀은 그대로 재사용 -> 받아온 정보 중, 보여줄 정보를 선택해서 바인딩 작업.
    // 예) 맛집의 제목, 맛집의 썸네일 이미지 URL 주소
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}