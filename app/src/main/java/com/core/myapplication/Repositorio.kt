package com.core.myapplication

import android.content.Context


class Repositorio:Repositorios {



    //var sessionManager=SessionManager(context)
    //sessionManager.createLoginSession(email,pass)

    override fun ReadUser(email: String, pass: String, context: Context): Boolean {



        var dataBase:DataBase= DataBase(context)
        var data=dataBase.readableDatabase(email,pass)

        var user=StringBuffer()
        var psw=StringBuffer()


        if(data!=null&&data.count>0){

            while (data.moveToNext()){

                user.append("${data.getString(0)}")
                psw.append("${data.getString(1)}")


            }


            if(!email.equals(user) || !pass.equals(psw)) {


                return true

            }else{

                return false
            }





        }else{

              return false

            }

    }


    override fun saveUser(email: String,pass: String, context:Context): Boolean {


        var dataBase:DataBase= DataBase(context)
        var user :User=User(email,pass)

        var result:Boolean=dataBase.insertData(user)



        when {
            result->return true
            else->return false
        }



    }


    override fun DeleteUser(email: String,context: Context): Boolean {


        var dataBase:DataBase= DataBase(context)
        var result:Boolean=dataBase.deleteData(email)

        when{

             result-> return true
                 else-> return false

        }

    }

    override fun UpdateUser(userAll: UserAll, context: Context): Boolean {

        var dataBase:DataBase= DataBase(context)
        var result:Boolean=dataBase.UpdateData(userAll)


        when{
            result->return true
            else-> return false
        }  }




}
