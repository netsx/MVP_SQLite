package com.core.myapplication.menu

import android.content.Context
import com.core.myapplication.Repositorio
import com.core.myapplication.Repositorios

class ModelDelete:MVP_Users.Model {


    var repositorio: Repositorios =Repositorio()
    var presenter:Presenter_delete

    constructor(Presenter_delete: Presenter_delete) {
        this.presenter = Presenter_delete
    }

    override fun deleteUser(string: String,context: Context) {

        var delete= repositorio.DeleteUser(string,context)

        when {
            delete ->presenter.responseRemove()
            else->presenter.responseRemove()
        }
    }

}