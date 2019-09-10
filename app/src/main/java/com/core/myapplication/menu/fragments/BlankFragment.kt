package com.core.myapplication.menu.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.core.myapplication.R
import com.core.myapplication.menu.MenuActivity
import kotlinx.android.synthetic.main.fragment_blank.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAMID = "param3"


class BlankFragment : Fragment() ,MVP_Update.View{



    private var param1: String? = null
    private var param2: String? = null
    private var param3: Int?=null



    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3= it.getInt(ARG_PARAMID)

        }
    }

    lateinit var presenter:PresenterUpdateUser

    private lateinit var text:TextView
    private lateinit var email:EditText
    private lateinit var pass:EditText

    private lateinit var butto:Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {


        presenter = PresenterUpdateUser(this)
        val view: View = inflater.inflate(R.layout.fragment_blank, container,
            false)

         text = view.findViewById<TextView>(R.id.response)
         email = view.findViewById<EditText>(R.id.email_upd)
         pass = view.findViewById<EditText>(R.id.passw_upd)
        butto =view.findViewById<AppCompatButton>(R.id.buttonAccep)


        butto.setOnClickListener {

            presenter.onClickButton()
        }
        email.setText(param1)
        pass.setText(param2)

        return view
    }


    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnFragmentInteractionListener) {
            listener = context

        } else {

            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {

        fun onFragmentInteraction(uri: Uri)
    }

    companion object {


        @JvmStatic
        fun newInstance(int: Int, param1: String, param2: String) = BlankFragment().apply {
                arguments = Bundle().apply {

                    putInt(ARG_PARAMID,int)
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }
    }


    override fun ongetId(): String {

        return this.param3.toString()
    }
    override fun OngetEmail(): String {


            return  this.email_upd.text.toString()
       }

    override fun OngetPassword(): String {



        return  this.passw_upd.text.toString()
    }

    override fun OngetContext(): Context {


        return this.requireActivity().applicationContext
    }

    override fun onShow(string: String) {

        Toast.makeText(requireActivity().applicationContext,string,Toast.LENGTH_LONG).show()

        val menuActivity:MenuActivity= activity as MenuActivity
        menuActivity.Datas()
    }
}
