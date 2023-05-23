package com.example.ch18_net_test1.retrofit




import com.example.test18_pdtest2.PageListModel
import com.example.test18_pdtest2.PageListModel2
import retrofit2.Call
import retrofit2.http.*


interface NetworkService {


    @GET("/api/food/img")
    fun getList(
        @Query("serviceKey") serviceKey: String?,
        @Query("pageNo") pageNo: Int
    ): retrofit2.Call<PageListModel>

    @GET("WalkingService/getWalkingKr")
    fun getList2(
        @Query("serviceKey") serviceKey: String?,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("resultType") resultType : String
    ): retrofit2.Call<PageListModel2>

}