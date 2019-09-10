package com.core.myapplication.menu.fragments

import android.content.Context
import com.core.myapplication.UserAll

interface MVP_Update {

    interface View{

        fun ongetId():String
        fun OngetEmail():String
        fun OngetPassword():String
        fun OngetContext():Context


        fun onShow(string: String)
    }

    interface Presenter{

        fun onClickButton()
        fun setView(view: MVP_Update.View)

        fun ongetUpdate(string: String)

    }

    interface Model{

        fun onUpdateData(user:UserAll,context: Context
        )
    }



}