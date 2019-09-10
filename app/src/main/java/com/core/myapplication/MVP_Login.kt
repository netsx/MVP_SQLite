package com.core.myapplication

import android.content.Context

interface MVP_Login {

    interface View{


        fun onErrorData(error:String );

        fun onSuccess()


        fun getEmail(): String
        fun getPassword(): String
        fun getContext():Context


    }

    interface Presenter{

        fun setView(view: MVP_Login.View)
        fun buttonLogin()
        fun getUser(boolean: Boolean)


        fun onCreate()
        fun onPause()
        fun onResume()
        fun onDestroy()





    }

    interface Model{

        fun onLoadData(email:String, password:String, context: Context)


        // fun removeProduct(product: Product)

    }
}