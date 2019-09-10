package com.core.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import com.core.myapplication.menu.MenuActivity
import com.core.myapplication.registro.FragmentRegistro




class MainActivity : AppCompatActivity() ,MVP_Login.View {

     lateinit var presenter: Presenter


    var session= SessionManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        session.SessionManager(applicationContext)
        session.checkLogin()

        presenter = Presenter(this)




        button_login.setOnClickListener {

            hideView()
            presenter.buttonLogin()

        }


        textView.setOnClickListener {



            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.addToBackStack(null)
            val dialogFragment = FragmentRegistro() //here MyDialog is my custom dialog
            dialogFragment.show(fragmentTransaction, "dialog")


        }

    }

    override fun onSuccess() {

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity( Intent (applicationContext,MenuActivity::class.java))
        finish()
    }

    override fun onErrorData(error:String) {

        showView()
        Toast.makeText(applicationContext,error,Toast.LENGTH_LONG).show()
    }




    override fun getEmail(): String {

        return this.textemail.text.toString()
    }

    override fun getPassword(): String {

        return this.textpass.text.toString()
    }
    override fun getContext(): Context {

        return this.applicationContext
    }

    fun showView (){
            content_login_progress.visibility=View.GONE
            cardView_login.visibility=View.VISIBLE
    }
    fun hideView(){
        content_login_progress.visibility=View.GONE
        cardView_login.visibility=View.VISIBLE

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(
            android.R.anim.slide_in_left,
            android.R.anim.slide_out_right
        )
    }


}
