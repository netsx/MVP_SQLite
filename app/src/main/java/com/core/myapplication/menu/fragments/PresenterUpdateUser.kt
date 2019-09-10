package com.core.myapplication.menu.fragments

import com.core.myapplication.UserAll
import org.jetbrains.annotations.NotNull

class PresenterUpdateUser:MVP_Update.Presenter {



    @NotNull
    private var view:MVP_Update.View
    private var model:MVP_Update.Model

    constructor(view: MVP_Update.View) {

        this.view = view
        this.model = ModelUpdateUser(this)

    }

    override fun setView(view: MVP_Update.View) {

        this.view=view
    }

    override fun onClickButton() {

        var user=UserAll(view.ongetId().toInt(),view.OngetEmail(),view.OngetPassword())

        view.ongetId()
        view.OngetEmail()
        view.OngetPassword()
        model.onUpdateData(user,view.OngetContext())


    }
    override fun ongetUpdate(string: String){


        view.onShow(string)

    }


}