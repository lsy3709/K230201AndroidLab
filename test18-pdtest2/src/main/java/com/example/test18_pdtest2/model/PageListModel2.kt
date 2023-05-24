package com.example.test18_pdtest2

import com.google.gson.annotations.SerializedName

//도보여행
data class PageListModel2 (
    //var data: List<ItemModel>?
        var getWalkingKr: GetWalkingKr
)

data class GetWalkingKr (
    var item : List<ItemModel3>
        )

data class ItemModel3 (
    @SerializedName("TITLE")
    var TITLE: String,
    @SerializedName("MAIN_IMG_NORMAL")
    var MAIN_IMG_NORMAL: String
)
