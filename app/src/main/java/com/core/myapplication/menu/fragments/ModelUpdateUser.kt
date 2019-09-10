package com.core.myapplication.menu.fragments

import android.content.Context
import com.core.myapplication.Repositorio
import com.core.myapplication.UserAll

class ModelUpdateUser:MVP_Update.Model {


    private var presenter:PresenterUpdateUser
    private var repositorio=Repositorio()



    constructor(presenter: PresenterUpdateUser) {
        this.presenter = presenter
    }

    override fun onUpdateData(user: UserAll, context: Context) {

        var update :Boolean=repositorio.UpdateUser(user ,context)

        when{
            update-> presenter.ongetUpdate("success")
                else->presenter.ongetUpdate("error")

        }
    }


}