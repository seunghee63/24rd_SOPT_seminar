package com.song2.a2nd_seminar

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_write_comment.*

class WriteCommentActivity : AppCompatActivity() {

    lateinit var selectedPicUri : Uri

    val REQUEST_CODDE_SELECT_IMAGE = 1004

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_comment)

        configureToolbar()

    }

    private fun configureToolbar(){

        tv_write_comment_activity_cancel.setOnClickListener {
            finish()
        }

        iv_comments_act_write_camera_btn.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
            intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent, REQUEST_CODDE_SELECT_IMAGE)
        }

        tv_write_comment_activity_submit.setOnClickListener {
            postCommentResponse()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODDE_SELECT_IMAGE){
            if(resultCode == Activity.RESULT_OK){
                data?.let{

                    selectedPicUri = it.data
                    Glide.with(this).load(selectedPicUri)
                        .thumbnail(0.1f).into(iv_comments_act_write_camera_btn)
                }
            }
        }
    }

    private fun postCommentResponse(){

    }
}
