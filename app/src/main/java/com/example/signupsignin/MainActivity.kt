package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignin=findViewById<Button>(R.id.btnSignIn)
        val btnSignUp=findViewById<Button>(R.id.btnSignup)

        btnSignin.setOnClickListener(){
            intent= Intent(this, SignIn::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener(){
            intent= Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}