package com.song2.a2nd_seminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_MAIN_ACTIVITY = 2000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainLogin.setOnClickListener {

            startActivityForResult<LoginActivity>(REQUEST_CODE_MAIN_ACTIVITY)

        }

        btnMainClose.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_MAIN_ACTIVITY)
            if(resultCode == Activity.RESULT_OK)
            {
                val user_id : String = data!!.getStringExtra("userID")
                toast("${user_id}님, 환영합니다!")

            }
    }


}
