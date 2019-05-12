package com.song2.a2nd_seminar.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.song2.a2nd_seminar.Data.EpisodeOverviewData
import com.song2.a2nd_seminar.R
import com.song2.a2nd_seminar.WebtoonActivity
import org.jetbrains.anko.startActivity

class EpisodeOverviewRecyclerViewAdapter(val ctx : Context, val dataList :ArrayList<EpisodeOverviewData>): RecyclerView.Adapter<EpisodeOverviewRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) :Holder{
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_episode_overview,viewGroup,false)
        return Holder(view)
    }
    override fun getItemCount():Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.container.setOnClickListener {
            ctx.startActivity<WebtoonActivity>("title" to dataList[position].title
            )
        }

        Glide.with(ctx)
            .load(dataList[position].img_url)
            .into(holder.img_thumbnail)
        holder.title.text = dataList[position].title
        holder.upload_date.text = dataList[position].upload_date
        holder.views.text = "조회수 "+dataList[position].views.toString() +"회"
    }

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var container = itemView.findViewById(R.id.rl_rv_item_episode_overview_container) as RelativeLayout
        var img_thumbnail = itemView.findViewById(R.id.img_rv_item_episode_overview_thumbnail) as ImageView
        var title = itemView.findViewById(R.id.tv_rv_item_episode_title) as TextView
        var upload_date = itemView.findViewById(R.id.tv_rv_item_episode_upload_date) as TextView
        var views = itemView.findViewById(R.id.tv_rv_item_episode_views)as TextView
    }
}