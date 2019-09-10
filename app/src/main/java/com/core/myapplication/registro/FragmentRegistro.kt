package com.core.myapplication.registro


import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast
import com.core.myapplication.R
import com.core.myapplication.menu.MenuActivity
import kotlinx.android.synthetic.main.dialog_signin.view.*


class FragmentRegistro : DialogFragment(),MVP_Load.View {



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val builder = android.support.v7.app.AlertDialog.Builder(activity!!)
        val presenter=Presenter(this)
        val view = activity!!.layoutInflater.inflate(R.layout.dialog_signin, null)
        builder.setView(view)

        val dialog = builder.create()


        view.buttonCancel.setOnClickListener {

            dialog.cancel()
        }

        view.buttonAccept.setOnClickListener {

                presenter.buttonLogin(view.email_reg.text.toString(),
                    view.passw_reg.text.toString(),
                    requireActivity().applicationContext)
        }


        return dialog
    }



    override fun onErrorData(error: String) {

        Toast.makeText(activity,error,Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(success: String) {

        startActivity( Intent (activity, MenuActivity::class.java))

    }




}