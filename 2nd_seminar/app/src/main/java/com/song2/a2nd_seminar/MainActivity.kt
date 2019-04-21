package com.song2.a2nd_seminar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainLogin.setOnClickListener {

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        btnMainClose.setOnClickListener {
            finish()
        }
    }


}
