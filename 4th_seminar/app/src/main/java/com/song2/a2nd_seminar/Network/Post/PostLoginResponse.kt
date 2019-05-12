package com.song2.a2nd_seminar.Network.Post

data class PostLoginResponse(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : String?
)