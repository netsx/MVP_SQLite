package com.core.myapplication.registro

import android.content.Context
import com.core.myapplication.Repositorio
import com.core.myapplication.Repositorios
import com.core.myapplication.SessionManager


class Model:MVP_Load.Model {


    var repositorio: Repositorios = Repositorio()
    var presenter:Presenter
    var sessionManager=SessionManager()

    constructor(presenter: Presenter) {

        this.presenter = presenter

    }


    override fun onLoadData(email: String, password: String, context: Context) {

        var result= repositorio.ReadUser(email,password,context)

        if(result==true){

            sessionManager.SessionManager(context)
            sessionManager.createLoginSession(email,password)
            presenter.getUser(result)

        }else{

            presenter.getUser(result)
        }


    }

    override fun subscribeUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribeUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}