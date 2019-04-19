package com.song2.a1st_seminar

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.song2.a1st_seminar.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivityForResult
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN_ACTIVITY = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //setOnFocusChangeListener 파라미터{바뀌는 뷰, 활성회가 되었는가}
        edt_login_id.setOnFocusChangeListener { v, hasfocus ->
            if (hasfocus == true) {
                v.setBackgroundResource(R.drawable.primary_border_gray)
            } else
                v.setBackgroundResource(R.drawable.primary_border)
        }
        edt_login_pw.setOnFocusChangeListener { v, hasfocus ->
            if (hasfocus == true) {
                v.setBackgroundResource(R.drawable.primary_border_gray)
            } else
                v.setBackgroundResource(R.drawable.primary_border)
        }
        btn_login_submit.setOnClickListener {

            if (edt_login_id.text.toString() == "") {
                //아무것도 입력받지 않은 상태는 공백임!

                edt_login_id.requestFocus()

            }
/*            else if (){
                //비밀번호가 공백일 때

            }
            else if(){
                //이름이 공백일 때
            }*/
            else
                finish()
        }
        tv_login_singup.setOnClickListener {


            //현재 날짜 String 형태로 가지고 옴
            val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val s_time = simpleDateFormat.format(Date())


            val intent = Intent(this, SignUpActivity::class.java)
            intent.putExtra("time", s_time)
            startActivityForResult<SignUpActivity>(REQUEST_CODE_LOGIN_ACTIVITY, "start_time" to s_time)

            finish()
        }

    }


    //아이디 디비에 저장
    fun postLoginResponse(u_id: String, u_pw: String) {
        SharedPreferenceController.setUserID(this, u_id)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_LOGIN_ACTIVITY) {
            if (requestCode == Activity.RESULT_OK) {
                val e_time = data!!.getStringExtra("end_time")

                Toast.makeText(this, "End time: ${e_time}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
