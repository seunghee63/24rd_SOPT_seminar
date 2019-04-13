package com.song2.a1st_seminar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        

        //setOnFocusChangeListener 파라미터{바뀌는 뷰, 활성회가 되었는가}
        edt_login_id.setOnFocusChangeListener { v, hasfocus ->
            if(hasfocus == true){
                v.setBackgroundResource(R.drawable.primary_border_gray)
            }
            else
                v.setBackgroundResource(R.drawable.primary_border)
        }

        edt_login_pw.setOnFocusChangeListener { v, hasfocus ->
            if(hasfocus == true){
                v.setBackgroundResource(R.drawable.primary_border_gray)
            }
            else
                v.setBackgroundResource(R.drawable.primary_border)
        }

/*        btn_login_submit.setOnClickListener {

            if(edt_login_id.text.toString()==""){
                //아무것도 입력받지 않은 상태는 공백임!

                edt_login_id.requestFocus()

            }
            else if (){
                //비밀번호가 공백일 때

            }
            else if(){
                //이름이 공백일 때

            }else
                finish()
        }*/
    }
}
