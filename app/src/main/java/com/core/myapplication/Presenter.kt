package com.core.myapplication

import android.content.Context
import android.content.Intent
import android.support.annotation.NonNull
import android.widget.Toast
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class Presenter : MVP_Login.Presenter{



    @NonNull
    private var view: MVP_Login.View
    private var model:MVP_Login.Model




    constructor(view: MVP_Login.View) {

        this.view = view
        this.model = Model(this)

    }

    override fun setView(view: MVP_Login.View) {

        this.view=view

    }



    override fun buttonLogin() {


            if(view != null){

                if(view.getEmail().isEmpty() || view.getPassword().isEmpty())
                    {
                        view.onErrorData("Campo requerido")

                    }else   {

                                if(view.getPassword().length<2 ||
                                        !android.util.Patterns.EMAIL_ADDRESS.matcher(view.getEmail()).matches())
                                        {
                                            view.onErrorData("campo requerdio")

                                        }else {
                                                   //   val user: User = User(view.getEmail().toString().trim(),view.getPassword())
                                                    model.onLoadData(view.getEmail().trim(),view.getPassword(),view.getContext())

                                                }

                        }


            }

    }

    override fun getUser(boolean: Boolean) {


        if(view!=null) {

            when {
                boolean -> view.onSuccess()
                else -> view.onErrorData("Ya hay un usuario registrado")
            }
        }


       }

    override fun onCreate() {

        EventBus.getDefault().register(this)
    }

    override fun onPause() {



    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {

        EventBus.getDefault().unregister(this)
      //  view = null
    }


}