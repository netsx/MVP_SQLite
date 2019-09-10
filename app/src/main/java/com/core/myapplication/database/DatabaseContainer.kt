package com.core.myapplication.database

import android.provider.BaseColumns

class DatabaseContainer {

        class user:BaseColumns{

            companion object{

                val ID_USER ="ID"
                val TABLE_NAME ="USUARIO"
                val EMAIL="EMAIL"
                val PASSWORD="PASSWORD"

            }

        }
}