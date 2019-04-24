package com.song2.a2nd_seminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.song2.a2nd_seminar.adapter.ProductMainPagerAdapter
import com.song2.a2nd_seminar.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(){

    val REQUEST_CODE_MAIN_ACTIVITY = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureMainTab()

        txt_toolbar_main_action.setOnClickListener {
            if(SharedPreferenceController.getUserID(this).isEmpty()){
                startActivity<LoginActivity>()
            }
            else{
                SharedPreferenceController.clearUserID(this)
                configureTitleBar()
            }
        }

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

    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }

    private fun configureTitleBar(){
        if(SharedPreferenceController.getUserID(this).isEmpty()){
            txt_toolbar_main_action.text = "로그인"
        }
        else{
            txt_toolbar_main_action.text = "로그아웃"
        }
    }


    private fun configureMainTab(){
        vp_main_product.adapter = ProductMainPagerAdapter(supportFragmentManager, 3)
        vp_main_product.offscreenPageLimit = 2

        tl_main_category.setupWithViewPager(vp_main_product)

        val navCategoryMainLayout : View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_category_main, null, false)
        tl_main_category.getTabAt(0)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_all) as RelativeLayout
        tl_main_category.getTabAt(1)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_new) as RelativeLayout
        tl_main_category.getTabAt(2)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_end) as RelativeLayout

    }


}
