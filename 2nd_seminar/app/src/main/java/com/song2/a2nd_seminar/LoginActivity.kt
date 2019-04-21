package com.song2.a2nd_seminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN_ACTIVITY = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        et_login_id.setOnFocusChangeListener { v, hasfocus ->
            if (hasfocus == true)
                v.setBackgroundResource(R.drawable.yellow_border)
            else
                v.setBackgroundResource(R.drawable.gray_border)
        }

        et_login_pw.setOnFocusChangeListener { v, hasfocus ->
            if (hasfocus == true)
                v.setBackgroundResource(R.drawable.yellow_border)
            else
                v.setBackgroundResource(R.drawable.gray_border)
        }

        btn_login_submit.setOnClickListener {
            if(et_login_id.text.toString() == "")  {
                et_login_id.setBackgroundResource(R.drawable.yellow_border)
                et_login_pw.setBackgroundResource(R.drawable.gray_border)

            }else if(et_login_pw.text.toString() == "") {
                et_login_pw.setBackgroundResource(R.drawable.yellow_border)
                et_login_id.setBackgroundResource(R.drawable.gray_border)
            }
            else{
                startActivity<MainActivity>()
                finish()
            }

        }

        tv_login_signup.setOnClickListener {

            val simpleDateFormat = SimpleDateFormat("dd/M/yy hh:mm:ss")
            val s_time = simpleDateFormat.format(Date())


            startActivityForResult<SignupActivity>(REQUEST_CODE_LOGIN_ACTIVITY, "start_time" to s_time)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE_LOGIN_ACTIVITY){
            if(resultCode == Activity.RESULT_OK) {
                val e_time = data!!.getStringExtra("end_time")

                toast("End time: ${e_time}")
            }
        }


    }
}
