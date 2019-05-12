package com.song2.a2nd_seminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.song2.a2nd_seminar.Network.ApplicationController
import com.song2.a2nd_seminar.Network.NetworkService
import com.song2.a2nd_seminar.Network.Post.PostSignupResponse
import com.song2.a2nd_seminar.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        et_signup_id.setOnFocusChangeListener { v, hasfocus ->
            if (hasfocus == true)
                v.setBackgroundResource(R.drawable.yellow_border)
            else
                v.setBackgroundResource(R.drawable.gray_border)
        }

        et_signup_pw.setOnFocusChangeListener { v, hasfocus ->
            if (hasfocus == true)
                v.setBackgroundResource(R.drawable.yellow_border)
            else
                v.setBackgroundResource(R.drawable.gray_border)
        }

        et_signup_name.setOnFocusChangeListener { v, hasfocus ->
            if (hasfocus == true)
                v.setBackgroundResource(R.drawable.yellow_border)
            else
                v.setBackgroundResource(R.drawable.gray_border)
        }

        btn_signup_submit.setOnClickListener {

            val signup_u_name : String = et_signup_name.text.toString()
            val signup_u_id = et_signup_id.text.toString()
            val signup_u_pw : String = et_signup_pw.text.toString()

            if(isVaild(signup_u_id, signup_u_pw,signup_u_name))
                postSignupResponse(signup_u_id, signup_u_pw,signup_u_name)

            if(et_signup_id.text.toString() == "")  {
                et_signup_id.setBackgroundResource(R.drawable.yellow_border)
                et_signup_pw.setBackgroundResource(R.drawable.gray_border)
                et_signup_name.setBackgroundResource(R.drawable.gray_border)
            }else if(et_signup_pw.text.toString() == "") {
                et_signup_pw.setBackgroundResource(R.drawable.yellow_border)
                et_signup_id.setBackgroundResource(R.drawable.gray_border)
                et_signup_name.setBackgroundResource(R.drawable.gray_border)
            }else if(et_signup_name.text.toString() == "") {
                et_signup_name.setBackgroundResource(R.drawable.yellow_border)
                et_signup_id.setBackgroundResource(R.drawable.gray_border)
                et_signup_pw.setBackgroundResource(R.drawable.gray_border)
            }
            else{
                if (isVaild(et_signup_id.text.toString(),et_signup_pw.text.toString(),et_signup_name.text.toString()) == true)
                    postSignupResponse(et_signup_id.text.toString(),et_signup_pw.text.toString(),et_signup_name.text.toString())
            }
        }
    }


    fun isVaild(u_id:String, u_pw:String, u_name:String):Boolean{

        if ( u_id !="" && u_pw !="" && u_name !="")
            return true
        else
            return false
    }

    fun postSignupResponse(u_id:String, u_pw: String, u_name: String){


        val jsonObject = JSONObject()
        jsonObject.put("id",u_id)
        jsonObject.put("password",u_pw)
        jsonObject.put("name",u_name)

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        val postSignupResponse : Call<PostSignupResponse>
                = networkService.postSignupResponse("application/json",gsonObject)
        postSignupResponse.enqueue(object : Callback<PostSignupResponse> {
            override fun onFailure(call: Call<PostSignupResponse>, t: Throwable) {
                Log.e("Signip failed", t.toString())
            }

            override fun onResponse(call: Call<PostSignupResponse>, response: Response<PostSignupResponse>) {
                if(response.isSuccessful){
                    toast(response.body()!!.message)
                    if(response.body()!!.status == 201){
                        Log.e("Signip success","success!")

                        val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                        val e_time = simpleDateFormat.format(Date())

                        val intent = Intent()
                        intent.putExtra("end_time",e_time)
                        setResult(Activity.RESULT_OK, intent)

                        finish()

                    }
                }
            }
        })


    }
}