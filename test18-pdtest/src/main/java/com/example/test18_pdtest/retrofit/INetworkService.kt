package com.example.test18_pdtest.retrofit


import com.example.test18_pdtest.Model.UserListModel
import com.example.test18_pdtest.Model.UserModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface INetworkService {
//    @GET("api/users")
    @GET("getFoodKr")
    // baseurl : https://reqres.in/
    //https://reqres.in/api/users?page=2
    //예를 들어서 doGetUserList("2")
//공공데이터 주소 샘플
//http://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=인증키&numOfRows=10&pageNo=1
    fun doGetUserList
            (
    @Query("resultType") resultType: String,
    @Query("serviceKey") serviceKey: String,
    @Query("numOfRows") numOfRows: Int,
    @Query("pageNo") pageNo: Int,

): Call<UserListModel>

    @GET
    fun getAvatarImage(@Url url: String): Call<ResponseBody>

//    @GET("users/list?sort=desc")
@GET("api/users/2")
    fun test1(): Call<UserModel>
}