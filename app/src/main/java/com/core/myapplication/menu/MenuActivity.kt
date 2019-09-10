package com.core.myapplication.menu

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v7.app.AlertDialog
import android.widget.AdapterView
import android.widget.ListView
import com.core.myapplication.DataBase
import com.core.myapplication.R
import com.core.myapplication.User
import com.core.myapplication.menu.fragments.BlankFragment


class MenuActivity : AppCompatActivity(),BlankFragment.OnFragmentInteractionListener,MVP_Users.View  {


    lateinit var presenter: Presenter_delete
    lateinit var  adapter : Adapter
    lateinit var listView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        presenter=Presenter_delete(this)

        val dataBase: DataBase = DataBase(applicationContext)
        var a=  dataBase.allData()



        listView= findViewById<ListView>(R.id.fragment_list)


        Datas()

        listView.setOnItemClickListener { adapterView, view, position: Int, id: Long ->

            openFragment(adapter.users.get(position).id,adapter.users.get(position).email,adapter.users.get(position).password)

        }




        listView.setOnItemLongClickListener(AdapterView.OnItemLongClickListener { adapterView, view, i, l ->
            val vibrator = applicationContext?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

            if (Build.VERSION.SDK_INT >= 26) {

                vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))

            }
            val dialogo1 = AlertDialog.Builder(this@MenuActivity)
            dialogo1.setTitle("Importante")
            dialogo1.setMessage("¿ Eliminar este usuario ?")
            dialogo1.setCancelable(false)
            dialogo1.setPositiveButton("Confirmar") { dialogo1, id ->

                  presenter.onClickDelete(adapter.users.get(i).email.toString())


            }
            dialogo1.setNegativeButton("Cancelar") { dialogo1, id -> }
            dialogo1.show()

            false
        })


    }



    fun openFragment(id:Int,email: String,pass: String) {

        val fragment = BlankFragment.newInstance(id,email,pass)
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.animation_right,
            R.anim.exit_to_right,
            R.anim.animation_right,
            R.anim.exit_to_right
        )
        transaction.addToBackStack(null)
        transaction.add(R.id.frame, fragment, "BLANK_FRAGMENT").commit()
    }


    override fun getContext(): Context {

        return this.applicationContext

    }
    override fun remove(user: User) {



    }

    override fun userRemove() {

        Datas()

    }

    override fun onFragmentInteraction(uri: Uri) {

    }


    fun Datas(){

        val dataBase= DataBase(applicationContext)
        var a=  dataBase.allData()

        adapter= Adapter(applicationContext, a)

        adapter.notifyDataSetChanged()

        listView.adapter=adapter
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
