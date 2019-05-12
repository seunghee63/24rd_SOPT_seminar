package com.song2.a2nd_seminar.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.song2.a2nd_seminar.Data.CommentsOverviewData
import com.song2.a2nd_seminar.R
import org.jetbrains.anko.find

class CommentsOverviewRecyclerViewAdapter(val ctx : Context, val dataList :ArrayList<CommentsOverviewData>) :RecyclerView.Adapter<CommentsOverviewRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) :Holder{
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_comments_overview,viewGroup,false)
        return Holder(view)
    }
    override fun getItemCount():Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.container.setOnClickListener {

        }
        holder.user_id.text = dataList[position].user_id
        holder.upload_date.text = dataList[position].date
        holder.contents.text = dataList[position].contents

    }



    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var container = itemView.findViewById(R.id.rl_rv_item_comments_container) as RelativeLayout
        var comments_img = itemView.findViewById(R.id.iv_rv_comments_img) as ImageView
        var user_id = itemView.findViewById(R.id.tv_rv_id) as TextView
        var upload_date = itemView.findViewById(R.id.tv_rv_time) as TextView
        var contents = itemView.findViewById(R.id.tv_rv_contents) as TextView
    }
}