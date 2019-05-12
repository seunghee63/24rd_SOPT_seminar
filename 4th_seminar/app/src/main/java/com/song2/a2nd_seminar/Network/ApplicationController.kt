package com.song2.a2nd_seminar.Network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController : Application(){

    private val baseURL = "http://hyunjkluz.ml:2424/"
    lateinit var networkService: NetworkService

    //어플리케이션컨트롤러 자체를 인스턴스로 만듦-> 후에 사용 가능
    companion object {
        lateinit var instance : ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }

    fun buildNetwork(){
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        networkService = retrofit.create(NetworkService::class.java)
    }


}