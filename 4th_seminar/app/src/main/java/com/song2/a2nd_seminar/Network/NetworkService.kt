package com.song2.a2nd_seminar.Network

import com.google.gson.JsonObject
import com.song2.a2nd_seminar.Network.Get.GetMainPRoductListResponse
import com.song2.a2nd_seminar.Network.Post.PostCommentResponse
import com.song2.a2nd_seminar.Network.Post.PostLoginResponse
import com.song2.a2nd_seminar.Network.Post.PostSignupResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @POST("/api/auth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type : String,
        @Body() body: JsonObject
    ): Call<PostLoginResponse>

    @POST("/api/auth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type : String,
        @Body() body: JsonObject
    ): Call<PostSignupResponse>

    @Multipart
    @POST("/api/webtoons/episodes/cmts")
    fun postCommentResponse(
        @Header("token") token : String,

        @Part("epIdx") epIdx : Int,
        @Part("content") content : RequestBody,
        @Part cmtImg : MultipartBody.Part
    ) : Call<PostCommentResponse>

    @GET("/api/webtoons/main/{flag}")
    fun getMainProductListResponse(
        @Header("Content-Type") content_type : String,
        @Path("flag") flag:Int
    ): Call<GetMainPRoductListResponse>
}