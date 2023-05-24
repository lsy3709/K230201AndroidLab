package com.example.test18_pdtest2


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test18_pdtest2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //키는 다른 파일에 저장해서, 불러와서 사용하고,
        // 키를 가지고 있는 파일은 .gitIgnore 등록 후 , 원격지에 푸쉬 안함.
        val serviceKey = "tVW2KFmuQi45yJsJGHm71Ud8PRLHZJvrLgyJp7NYkEaT0aVvlkr82a5JJJZrVu4O"
        val serviceKey2 = "ALRX9GpugtvHxcIO%2FiPg1vXIQKi0E6Kk1ns4imt8BLTgdvSlH%2FAKv%2BA1GcGUQgzuzqM3Uv1ZGgpG5erOTDcYRQ%3D%3D"
        val serviceKey3 = "ALRX9GpugtvHxcIO/iPg1vXIQKi0E6Kk1ns4imt8BLTgdvSlH/AKv+A1GcGUQgzuzqM3Uv1ZGgpG5erOTDcYRQ=="
        val resultType ="json"

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkService = (applicationContext as MyApplication).networkService

         // 부산 도보여행 정보 서비스 : getList2, PageListModel2.
        // 부산맛집정보성비스 : getList, PageListModel
        //부산맛집 _순서1
        val userListCall = networkService.getList(serviceKey3,1,100,resultType)
        //도보여행_순서1
//        val userListCall = networkService.getList2(serviceKey3,1,100,resultType)
        Log.d("lsy", "url:" + userListCall.request().url().toString())

        //부산맛집 _ 순서2
        userListCall.enqueue(object : Callback<PageListModel> {
            //도보여행_ 순서2
//            userListCall.enqueue(object : Callback<PageListModel2> {
            //도보여행 _ 순서3
//            override fun onResponse(call: retrofit2.Call<PageListModel2>, response: Response<PageListModel2>) {
            //부산 맛집 _ 순서3
            override fun onResponse(call: retrofit2.Call<PageListModel>, response: Response<PageListModel>) {

                Log.d("lsy","실행 여부 확인. userListCall.enqueue")
                val userList = response.body()
                //도보여행 로그 _ 순서4
//                Log.d("lsy","userList data 값 : ${userList?.getWalkingKr?.item}")
                //부산맛집로그 _ 순서4
                Log.d("lsy","userList data 값 : ${userList?.getFoodKr?.item}")
                Log.d("lsy","userList data 갯수 : ${userList?.getFoodKr?.item?.size}")


                //도보여행 순서5
//                binding.recyclerView.adapter= MyAdapter(this@MainActivity,userList?.getWalkingKr?.item)

                //부산맛집 순서5
                binding.recyclerView.adapter= MyAdapter2(this@MainActivity,userList?.getFoodKr?.item)


                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
                )

//                binding.pageView.text=userList?.page
//                binding.totalView.text=userList?.total
            }

            //도보여행 _순서6
//            override fun onFailure(call: retrofit2.Call<PageListModel2>, t: Throwable) {
            //부산맛집 _순서6
            override fun onFailure(call: retrofit2.Call<PageListModel>, t: Throwable) {
                Log.d("lsy","fail")
                call.cancel()
            }
        })

        /*  val userListCall = networkService.getList(serviceKey,1)
          Log.d("lsy", "url:" + userListCall.request().url().toString())

          userListCall.enqueue(object : Callback<PageListModel> {
              override fun onResponse(call: Call<PageListModel>, response: Response<PageListModel>) {

                  val userList = response.body()
                  Log.d("lsy","userList data 값 : ${userList?.body}")
                  //.......................................

                  binding.recyclerView.adapter=MyAdapter(this@MainActivity, userList?.body)

                  binding.recyclerView.addItemDecoration(
                      DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
                  )

  //                binding.pageView.text=userList?.page
  //                binding.totalView.text=userList?.total
              }

              override fun onFailure(call: Call<PageListModel>, t: Throwable) {
                  call.cancel()
              }
          })*/



    }
}