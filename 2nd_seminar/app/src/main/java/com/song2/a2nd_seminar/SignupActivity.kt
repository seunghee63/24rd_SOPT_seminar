package com.song2.a2nd_seminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signup.*
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

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

        val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val e_time = simpleDateFormat.format(Date())

        val intent = Intent()
        intent.putExtra("end_time",e_time)
        setResult(Activity.RESULT_OK, intent)

        finish()
    }
}