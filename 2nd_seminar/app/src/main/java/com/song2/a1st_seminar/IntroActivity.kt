package com.song2.a1st_seminar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro.*


class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)


        btnMainLogin.setOnClickListener{

            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("id",1)
            startActivity(intent)

        }

        btnMainClose.setOnClickListener{
            finish()
        }
    }
}
