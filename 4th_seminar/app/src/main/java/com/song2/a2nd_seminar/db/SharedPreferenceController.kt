package com.song2.a2nd_seminar.db

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController {

    val MY_ACCOUNT = "unique_string"

    fun setUserToken(ctx: Context, time:String){
        val preference : SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = preference.edit()

        editor.putString("u_token",time)
        editor.commit()
    }

    fun getUserToken(ctx : Context):String{
        val preferences:SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return preferences.getString("u_token","")
    }

    fun clearUserToken(ctx : Context){
        val preferences : SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT,Context.MODE_PRIVATE)
        val editor :SharedPreferences.Editor = preferences.edit()
        editor.clear()
        editor.commit()
    }
}