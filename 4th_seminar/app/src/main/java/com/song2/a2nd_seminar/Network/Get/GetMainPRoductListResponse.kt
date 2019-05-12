package com.song2.a2nd_seminar.Network.Get

import com.song2.a2nd_seminar.Data.ProductOverviewData

data class GetMainPRoductListResponse(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : ArrayList<ProductOverviewData>?
)