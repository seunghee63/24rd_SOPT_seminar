package com.song2.a2nd_seminar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.song2.a2nd_seminar.Data.CommentsOverviewData
import com.song2.a2nd_seminar.adapter.CommentsOverviewRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_comment.*
import org.jetbrains.anko.startActivity

class CommentActivity : AppCompatActivity() {

    lateinit var commentsOverviewRecyclerViewAdapter : CommentsOverviewRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)


        tv_btn_write_comments.setOnClickListener {
            startActivity<WriteCommentActivity>()
        }

        var dataList : ArrayList<CommentsOverviewData> = ArrayList()
        dataList.add(CommentsOverviewData(
            0,
            "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045" ,
            "승히",
            "19.01.91 10.10.10",
            "김무현바보바보바보바보바보 블라디도못가는바보바보바보"
        ))
        dataList.add(CommentsOverviewData(
            0,
            "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045" ,
            "무현",
            "19.01.91 10.10.10",
            "문어에 대한 내용이 아주 유익하네요. 추천드려요! 다들 꼭 보시길~^^"
        ))


        commentsOverviewRecyclerViewAdapter = CommentsOverviewRecyclerViewAdapter(this,dataList)
        rv_comments.adapter = commentsOverviewRecyclerViewAdapter
        rv_comments.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
    }
}
