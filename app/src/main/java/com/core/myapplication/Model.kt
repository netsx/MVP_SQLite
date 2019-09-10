package com.core.myapplication
import android.content.Context
class Model:MVP_Login.Model {


     var repositorio: Repositorios=Repositorio()
     var presenter: Presenter



    constructor(presenter: Presenter) {
        this.presenter = presenter


    }
    override fun onLoadData(email: String, password: String, context: Context) {


        var read= repositorio.ReadUser(email,password,context)


             if(read==true){

                 presenter.getUser(false)

             }else{



                 presenter.getUser(read)
                 var result = repositorio.saveUser(email, password, context)
                 if(result == true){

                     var sessionManager= SessionManager()
                     sessionManager.SessionManager(context)
                     sessionManager.createLoginSession(email,password)

                     presenter.getUser(result)

                 }

             }

    }

}



