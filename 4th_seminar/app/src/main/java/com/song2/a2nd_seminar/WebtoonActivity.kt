package com.song2.a2nd_seminar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar_product.*
import org.jetbrains.anko.startActivity

class WebtoonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webtoon)

        var title = intent.getStringExtra("title")
        txt_toolbar_product_title.text = title

        btn_toolbar_product_back.setOnClickListener {
            finish()
        }

        txt_toolbar_product_title.setOnClickListener {
            startActivity<CommentActivity>()
        }


    }
}
