package com.core.myapplication

import android.content.Context

interface Repositorios {
    fun saveUser(email:String,pass:String,context: Context):Boolean

    fun ReadUser(email:String,pass:String,context: Context):Boolean

    fun DeleteUser(string: String,context: Context):Boolean

    fun UpdateUser(userAll: UserAll,ontext: Context):Boolean
}