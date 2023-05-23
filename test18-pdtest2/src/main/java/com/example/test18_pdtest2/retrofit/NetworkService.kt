package com.example.ch18_net_test1.retrofit




import com.example.test18_pdtest2.PageListModel
import com.example.test18_pdtest2.PageListModel2
import retrofit2.Call
import retrofit2.http.*


interface NetworkService {


    //부산맛집정보성비스
    // itemModel, PageListModel 참고
//    http://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=인증키&numOfRows=10&pageNo=1
    @GET("FoodService/getFoodKr")
    fun getList(
        @Query("serviceKey") serviceKey: String?,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("resultType") resultType : String
    ): retrofit2.Call<PageListModel>

    // 부산 도보여행 정보 서비스
    // itemModel2, PageListModel2 참고
    //http://apis.data.go.kr/6260000/WalkingService/getWalkingKr?serviceKey=인증키&numOfRows=10&pageNo=1
    @GET("WalkingService/getWalkingKr")
    fun getList2(
        @Query("serviceKey") serviceKey: String?,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("resultType") resultType : String
    ): retrofit2.Call<PageListModel2>

}