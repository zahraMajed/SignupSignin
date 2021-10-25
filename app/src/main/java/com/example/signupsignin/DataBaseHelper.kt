package com.example.signupsignin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context?) : SQLiteOpenHelper(context, "data.db", null, 1) {
    lateinit var sqlite:SQLiteDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table Users (Name text, Mobile text, Location text, Password text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    //insertData
    fun insertUser(name:String,mobile:String, location:String, password:String){
        //
        sqlite=writableDatabase
        //
        val ConVal=ContentValues()
        ConVal.put("Name",name)
        ConVal.put("Mobile",mobile)
        ConVal.put("Location",location)
        ConVal.put("Password",password)
        //
        sqlite.insert("Users", null, ConVal)
    }
    //getData
    @SuppressLint("Range")
    fun getData(mobile:String): ArrayList<List<String>> {
        var UserData= arrayListOf<List<String>>()
        sqlite=writableDatabase
        val cursor:Cursor=sqlite.query("Users" , null,"Mobile=?", arrayOf(mobile), null, null,null)
        if(cursor.moveToFirst())
            do {
                UserData.add(listOf(
                    cursor.getString(cursor.getColumnIndex("Name")),
                    cursor.getString(cursor.getColumnIndex("Mobile")),
                    cursor.getString(cursor.getColumnIndex("Location")),
                    cursor.getString(cursor.getColumnIndex("Password"))
                ))
            }while (cursor.moveToNext())
        return UserData
    }

}//end class