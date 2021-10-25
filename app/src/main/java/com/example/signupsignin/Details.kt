package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Details : AppCompatActivity() {

    lateinit var tvWelconDetails:TextView
    lateinit var tvDetails:TextView
    lateinit var btnSignOut:Button

    val dbHelper=DataBaseHelper(this)
    var userInfoList= arrayListOf<List<String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        tvWelconDetails=findViewById(R.id.tvWelconDetails)
        tvDetails=findViewById(R.id.tvDetails)
        btnSignOut=findViewById(R.id.btnSignOut)

        getData()

        btnSignOut.setOnClickListener(){
            intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun getData(){
        val mobile=intent.getStringExtra("mobile")
        userInfoList.addAll(dbHelper.getData(mobile!!))
        tvWelconDetails.text=" ${tvWelconDetails.text} ${userInfoList[0][0]}"
        tvDetails.text=" Phone number: ${userInfoList[0][1]} \n\n Location:${userInfoList[0][2]} "
    }
}