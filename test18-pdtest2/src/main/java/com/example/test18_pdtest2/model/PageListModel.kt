package com.example.test18_pdtest2

import com.example.test18_pdtest2.ItemModel
import com.google.gson.annotations.SerializedName

//부산맛집탐방
data class PageListModel (
    //var data: List<ItemModel>?
    var getFoodKr: GetFoodKr
)

data class GetFoodKr (
    var item : List<ItemModel4>
)

data class ItemModel4 (
    @SerializedName("TITLE")
    var TITLE: String,
    @SerializedName("MAIN_IMG_NORMAL")
    var MAIN_IMG_NORMAL: String,
    //연락처
    @SerializedName("CNTCT_TEL")
    var CNTCT_TEL: String,

)