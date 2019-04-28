package com.song2.a2nd_seminar.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.song2.a2nd_seminar.Data.ProductOverviewData

import com.song2.a2nd_seminar.R
import com.song2.a2nd_seminar.adapter.ProductOverviewRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_new_product_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NewProductMainFragment : Fragment() {

    lateinit var productOverviewRecyclerViewAdapter : ProductOverviewRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_product_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<ProductOverviewData> = ArrayList()
        dataList.add(
            ProductOverviewData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                8,"신규작품 1",120,"신규작가 A")
        )
        dataList.add(
            ProductOverviewData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                9, "신규작품 2", 100, "신규작가 B")
        )
        dataList.add(
            ProductOverviewData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                10, "신규작품 3", 99, "신규작가 C")
        )
        dataList.add(
            ProductOverviewData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                11, "신규작품 4", 10, "신규작가 D")
        )
        dataList.add(
            ProductOverviewData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                12, "신규작품 5", 1, "신규작가 E")
        )
        dataList.add(
            ProductOverviewData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                13, "신규작품 6", 1, "신규작가 F")
        )
        dataList.add(
            ProductOverviewData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                14, "신규작품 7", 1, "신규작가 G")
        )
        dataList.add(
            ProductOverviewData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                15, "신규작품 8", 1, "신규작가 H")
        )

        productOverviewRecyclerViewAdapter = ProductOverviewRecyclerViewAdapter(context!!,dataList)
        rv_product_overview_new.adapter = productOverviewRecyclerViewAdapter
        rv_product_overview_new.layoutManager = GridLayoutManager(context!!, 3)
    }



}
