package com.song2.a2nd_seminar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.song2.a2nd_seminar.Data.EpisodeOverviewData
import com.song2.a2nd_seminar.adapter.EpisodeOverviewRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.toolbar_product.*

class ProductActivity : AppCompatActivity() {
    lateinit var episodeOverviewRecyclerViewAdapter : EpisodeOverviewRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        var title = intent.getStringExtra("title")
        txt_toolbar_product_title.text = title

        btn_toolbar_product_like.setOnClickListener {
            btn_toolbar_product_like.isSelected = !btn_toolbar_product_like.isSelected
        }

        btn_toolbar_product_back.setOnClickListener {
            finish()
        }

        var dataList : ArrayList<EpisodeOverviewData> = ArrayList()
        dataList.add(EpisodeOverviewData(
            0,
            "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045" ,
            "1화. 문어지지 말자!",
            30,
            "12:11:11"
        ))
        dataList.add(EpisodeOverviewData(
            0,
            "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045" ,
            "2화. 문어지지 말자 우리!",
            30,
            "12:11:11"
        ))

        episodeOverviewRecyclerViewAdapter = EpisodeOverviewRecyclerViewAdapter(this,dataList)
        rv_episode_overview_list.adapter = episodeOverviewRecyclerViewAdapter
        rv_episode_overview_list.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
    }
}
