package com.song2.a1st_seminar

import android.app.Activity
import android.app.SharedElementCallback
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.song2.a1st_seminar.R.drawable.logo
import com.song2.a1st_seminar.adapter.ProductMainPagerAdapter
import com.song2.a1st_seminar.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.configuration
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var temp : ArrayList<android.graphics.drawable.Drawable>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureMainTab()
/*
        temp.add(ContextCompat.getDrawable(this,logo)!!)
        temp.add(ContextCompat.getDrawable(this,logo)!!)
        temp.add(ContextCompat.getDrawable(this,logo)!!)

        var adpt : Adapter = Adapter(temp,this)

        var pager : ViewPager = (ViewPager)findViewById(R.id.photo_viewpager)*/

/*        btnMainLogin.setOnClickListener {

            //코틀린 변수선언
            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("id",1)
            startActivityForResult(intent, 24)

        }

        btnMainClose.setOnClickListener {
            finish()
        }*/

        txt_toolbar_main_action.setOnClickListener{

            //startActivity<LoginActivity>()

            if(SharedPreferenceController.getUserID(this).isEmpty()){

            }else
            {
                SharedPreferenceController.clearUserID(this)
                configureTitleBar()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }

    //

    private fun configureTitleBar(){
        if(SharedPreferenceController.getUserID(this).isEmpty()){
            txt_toolbar_main_action.text = "로그인"
        }
        else{
            txt_toolbar_main_action.text = "로그아웃"
        }
    }

    fun postSignupResponse(u_id:String, u_pw:String, u_name:String){

        val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val e_time = simpleDateFormat.format(Date())

        val intent = Intent()
        intent.putExtra("end_time",e_time)
        setResult(Activity.RESULT_OK, intent)

        finish()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 24){
            var userId : String = ""
            userId = data!!.getStringExtra("user_id")

            Toast.makeText(applicationContext, userId+"성공", Toast.LENGTH_SHORT).show()

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