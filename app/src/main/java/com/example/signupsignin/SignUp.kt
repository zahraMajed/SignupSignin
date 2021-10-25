package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {

    lateinit var edName1: EditText
    lateinit var edLocation1: EditText
    lateinit var edMobile1: EditText
    lateinit var edPassword1: EditText
    lateinit var btnSunSignup: Button

    lateinit var userName:String
    lateinit var userLoc:String
    lateinit var userMobile:String
    lateinit var userPassword:String
    //
    val dbHelper=DataBaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        edName1=findViewById(R.id.edNameSignUp)
        edLocation1=findViewById(R.id.edLocSignUp)
        edMobile1=findViewById(R.id.edMobileSignUp)
        edPassword1=findViewById(R.id.edPasswordSignUp)
        btnSunSignup=findViewById(R.id.btnSubSignUp)

        btnSunSignup.setOnClickListener(){
            if(edName1.text.isNotEmpty() && edLocation1.text.isNotEmpty() &&
                edMobile1.text.isNotEmpty() && edPassword1.text.isNotEmpty()){
                userName=edName1.text.toString()
                userLoc=edLocation1.text.toString()
                userMobile= edMobile1.text.toString()
                userPassword=edPassword1.text.toString()
                dbHelper.insertUser(userName,userMobile,userLoc,userPassword)
                intent= Intent(this,Details::class.java)
                intent.putExtra("mobile", userMobile)
                startActivity(intent)
            }else
                Toast.makeText(applicationContext, "Please fill your data!", Toast.LENGTH_SHORT).show()
        }//end btnSignUp listener
    }//end onCreate()
}//end class