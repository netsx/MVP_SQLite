package com.core.myapplication.menu

import android.content.Context
import com.core.myapplication.User
import org.jetbrains.annotations.NotNull

class Presenter_delete:MVP_Users.Presenter {

    @NotNull
    private var view:MVP_Users.View
    private var model:MVP_Users.Model

    constructor(view: MVP_Users.View) {
        this.view = view
        this.model = ModelDelete(this)
    }


    override fun setView(view: MVP_Users.View) {

        this.view=view
    }

    override fun onClickDelete(string: String) {

            model.deleteUser(string,view.getContext())

    }

    override fun responseRemove() {


        view.userRemove()


    }
}

