package com.core.myapplication.registro

import android.content.Context
import com.core.myapplication.MVP_Login
import com.core.myapplication.User

interface MVP_Load {

    interface View{


        fun onErrorData(error:String );

        fun onSuccess(success:String)




       // fun getEmail(): String
       // fun getPassword(): String
        //fun getContext(): Context


    }

    interface Presenter{

        fun setView(view: MVP_Login.View)
        fun buttonLogin(email: String,password: String,context: Context)
        fun getUser(boolean: Boolean)


        fun onCreate()
        fun onPause()
        fun onResume()
        fun onDestroy()





    }

    interface Model{

        fun onLoadData(email:String, password:String, context: Context)

        fun subscribeUser()
        fun unsubscribeUser()

        // fun removeProduct(product: Product)

    }
}