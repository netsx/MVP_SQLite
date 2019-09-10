package com.core.myapplication.menu

import android.content.Context
import com.core.myapplication.User

interface MVP_Users {

    interface View{


         fun remove(user: User)
         fun getContext():Context
         fun userRemove()


    }

    interface Presenter{

        fun setView(view: MVP_Users.View)
        fun onClickDelete(string: String)


        fun responseRemove()

    }

    interface Model{

        fun deleteUser(string: String,context: Context)

    }
}