package com.rendra.imakan.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.home.HomePageActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase
import com.rendra.imakan.signup.SignUpActivity


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btn_login.setOnClickListener {
            startActivity(Intent(this, HomePageActivity::class.java))
        }

        btn_register.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}