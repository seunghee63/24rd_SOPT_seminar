package com.song2.a2nd_seminar.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.song2.a2nd_seminar.Data.ProductOverviewData
import com.song2.a2nd_seminar.Network.ApplicationController
import com.song2.a2nd_seminar.Network.Get.GetMainPRoductListResponse
import com.song2.a2nd_seminar.Network.NetworkService

import com.song2.a2nd_seminar.R
import com.song2.a2nd_seminar.adapter.ProductOverviewRecyclerViewAdapter
import com.song2.a2nd_seminar.db.SharedPreferenceController
import kotlinx.android.synthetic.main.fragment_all_product_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllProductMainFragment : Fragment() {

    lateinit var productOverviewRecyclerViewAdapter :ProductOverviewRecyclerViewAdapter

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_product_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<ProductOverviewData> = ArrayList()
        productOverviewRecyclerViewAdapter = ProductOverviewRecyclerViewAdapter(context!!,dataList)
        rv_product_overview_all.adapter = productOverviewRecyclerViewAdapter
        rv_product_overview_all.layoutManager = GridLayoutManager(context!!, 3)

        getMainProductListResponse()
    }

    private fun getMainProductListResponse(){
        val getMainProductListResponse = networkService.getMainProductListResponse(
            "application/json",1)

        getMainProductListResponse.enqueue(object : Callback<GetMainPRoductListResponse>{
            override fun onFailure(call: Call<GetMainPRoductListResponse>, t: Throwable) {
                Log.e("AllMainProduct failed", t.toString())
            }

            override fun onResponse(
                call: Call<GetMainPRoductListResponse>,
                response: Response<GetMainPRoductListResponse>
            ) {
                if(response.isSuccessful){
                    if(response.body()!!.status == 200){
                        val tmp:ArrayList<ProductOverviewData> = response.body()!!.data!!
                        productOverviewRecyclerViewAdapter.dataList = tmp
                        productOverviewRecyclerViewAdapter.notifyDataSetChanged()

                    }
                }
            }
        })
    }
}
