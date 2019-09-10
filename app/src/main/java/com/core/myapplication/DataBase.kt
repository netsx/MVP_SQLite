package com.core.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import com.core.myapplication.database.DatabaseContainer.user.Companion.EMAIL
import com.core.myapplication.database.DatabaseContainer.user.Companion.ID_USER
import com.core.myapplication.database.DatabaseContainer.user.Companion.PASSWORD
import com.core.myapplication.database.DatabaseContainer.user.Companion.TABLE_NAME


class DataBase (context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null ,DATABASE_VERSION)
{
    override fun onCreate(db:SQLiteDatabase?) {

        val person ="CREATE TABLE " + TABLE_NAME + "(" + ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT," + EMAIL + " TEXT,"+ PASSWORD + " TEXT"+ ")"

        db!!.execSQL(person)



    }

    override fun onUpgrade(db: SQLiteDatabase?,oldVersion:Int, newVersion:Int)
        {

            db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")


        }



    fun insertData(user:User):Boolean{

        val contentValues= ContentValues()
        val db: SQLiteDatabase = this.writableDatabase

        contentValues.put(EMAIL,user.email)
        contentValues.put(PASSWORD,user.password)



        val insert_data =db.insert(TABLE_NAME,null ,  contentValues)
        db.close()

        return !insert_data.equals(-1)
    }
    fun readableDatabase(email:String,pasword:String):Cursor{

        val db: SQLiteDatabase = this.writableDatabase
        val read: Cursor =db.rawQuery("SELECT $EMAIL, $PASSWORD FROM $TABLE_NAME WHERE $EMAIL"+"=? "+" AND " +"$PASSWORD"+"=?" , arrayOf(email,pasword))

        return read

    }

    fun allData(): ArrayList<UserAll>{

        var user = ArrayList<UserAll>()

        var allUser: String = "";
        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectALLQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    var firstName = cursor.getString(cursor.getColumnIndex("$EMAIL"))
                    var lastName = cursor.getString(cursor.getColumnIndex("$PASSWORD"))
                    var id= cursor.getInt(cursor.getColumnIndex("$ID_USER"))

                    var all=UserAll(id,firstName,lastName )
                    user.add(all)

                    allUser = "$allUser\n $firstName "
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()

        return user
    }

    fun UpdateData(userAll: UserAll):Boolean{


        val contentValues= ContentValues()
        val db: SQLiteDatabase = this.writableDatabase

        contentValues.put(EMAIL,userAll.email)
        contentValues.put(PASSWORD,userAll.password)

        val update= db.update(TABLE_NAME, contentValues,"$ID_USER=?", arrayOf(userAll.id.toString()))

        return !update.equals(-1)

    }


    fun deleteData(email: String):Boolean{

        val db:SQLiteDatabase=this.writableDatabase
        // val delete_data=db.delete(TABLE_NAME,"$ID_USER=?", arrayOf())

        val delete_data=db.delete(TABLE_NAME,"$EMAIL=?", arrayOf(email))

        return !delete_data.equals(-1)

    }

    fun getDataView():Cursor{

        val db:SQLiteDatabase=this.readableDatabase

        val data :String="SELECT * FROM $TABLE_NAME";

        var cursor:Cursor=db.rawQuery(data,null)

        return cursor

    }

    companion object{

        private const val DATABASE_NAME="USER.db"
        private const val DATABASE_VERSION = 1
    }

}