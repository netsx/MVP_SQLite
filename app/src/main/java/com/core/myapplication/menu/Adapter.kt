package com.core.myapplication.menu

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.app.Activity
import android.content.Context
import com.core.myapplication.User
import android.view.LayoutInflater
import android.widget.TextView
import com.core.myapplication.R
import com.core.myapplication.UserAll


class Adapter(private val context: Context,  var users: ArrayList<UserAll>  ) : BaseAdapter() {



    override fun getItem(p0: Int): Any {

        return users.get(p0)

    }

    override fun getItemId(p0: Int): Long {

        return p0.toLong()

    }

    override fun getCount(): Int {

        return users.size

    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

      //  val inflater = context.getLayoutInflater()
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item, null, true)


        val detailTextView = view.findViewById(R.id.textView2) as TextView
           // view.textView2.setText(p0)

//        detailTextView.setText("email: "+user.get(p0).email +" pass: "+user.get(p0).password)

        detailTextView.setText("User Id: "+users.get(p0).id)




        return view

    }




    fun UpdateUser(user: UserAll){

        if (users.contains(user)) {

            val index = users.indexOf(user)
            users.set(index, user)

            notifyDataSetChanged()

            // notifyItemChanged(index)


        }
    }

    fun DeleteUser(user: UserAll){

        if (users.contains(user)) {
            val index = users.indexOf(user)
            users.removeAt(index)
            notifyDataSetChanged()

           // notifyItemRemoved(index)
        }

    }



}