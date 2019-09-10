package com.core.myapplication.registro

import android.content.Context
import com.core.myapplication.MVP_Login
import com.core.myapplication.Model

class Presenter:MVP_Load.Presenter {

     var view:MVP_Load.View
     var model:MVP_Load.Model

    constructor(view: MVP_Load.View) {
        this.view = view
        this.model = Model(this)
    }


    override fun setView(view: MVP_Login.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun buttonLogin(email: String,pass: String,context: Context) {

           if(view!=null){


               if(email.isEmpty() || pass.isEmpty()){

                   view.onErrorData("require data")

               }else{

                   model.onLoadData(email,pass,context)

               }

           }

      }

    override fun getUser(boolean: Boolean) {

           if(boolean){

               view.onSuccess("")

           }else{

               view.onErrorData("Usuario o contraseña no validos")
           }

    }

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}