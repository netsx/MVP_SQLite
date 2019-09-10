package com.core.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.core.myapplication.menu.MenuActivity





class SessionManager {


    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var context: Context


    var PRIVATE_MODE = 0
    private val PREF_NAME = "AndroidHivePref"
    private val IS_LOGIN = "IsLoggedIn"
    val KEY_NAME = "EMAIL"
    val KEY_EMAIL = "PASSWORD"



    fun SessionManager(context: Context){
        this.context = context
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun createLoginSession(email: String, pass: String) {

        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_NAME, email)
        editor.putString(KEY_EMAIL, pass)

        editor.commit()
    }




    fun checkLogin() {


        if (!this.isLoggedIn()) {

            var i =  Intent(context, MenuActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            context.startActivity(i);
        }
    }


    fun isLoggedIn(): Boolean {

        return pref.getBoolean(IS_LOGIN, false)

    }

    fun getUserDetails(): HashMap<String, String> {
        val user = HashMap<String, String>()

      //  user[KEY_NAME] = pref.getString(KEY_NAME, null)
        //user[KEY_EMAIL] = pref.getString(KEY_EMAIL, null)

        return user
    }
    fun logoutUser() {

        editor.clear()
        editor.commit()

        val i = Intent(context, MenuActivity::class.java)

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        context.startActivity(i)
    }


}