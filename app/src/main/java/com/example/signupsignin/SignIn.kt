package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {
    lateinit var edMobileSignin:EditText
    lateinit var edPasswordSignin:EditText
    lateinit var btnSubSignin:Button

    lateinit var userMobile2:String
    lateinit var userPassword:String

    val dbHelper=DataBaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        edMobileSignin=findViewById(R.id.edMobileSignin)
        edPasswordSignin=findViewById(R.id.edPasswordSignin)
        btnSubSignin=findViewById(R.id.btnSubSignIn)

        btnSubSignin.setOnClickListener(){
            if(edMobileSignin.text.isNotEmpty() && edPasswordSignin.text.isNotEmpty()) {
                userMobile2=edMobileSignin.text.toString()
                userPassword=edPasswordSignin.text.toString()
                if (getUserDBPassword() != null){
                    if (getUserDBPassword().equals(userPassword)){
                        intent= Intent(this,Details::class.java)
                        intent.putExtra("mobile",userMobile2)
                        startActivity(intent)
                    }else
                        Toast.makeText(applicationContext, "Wrong password or phone number, try again!", Toast.LENGTH_SHORT).show()
                }else
                    Toast.makeText(applicationContext, "Wrong password or phone number, try again!", Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(applicationContext, "Please fill your data!", Toast.LENGTH_SHORT).show()
            }

        }//end onCreate()

    fun getUserDBPassword(): String? {
        var userDBPassword:String ?=null
        if (dbHelper.getData(userMobile2)!=null){
            for (i in dbHelper.getData(userMobile2)){
                userDBPassword=i[3]
            }
        }
        return userDBPassword
    }//end getUserDBPassword()
}
