package com.rendra.imakan.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.home.HomePageActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btn_login.setOnClickListener {
            startActivity(Intent(this, HomePageActivity::class.java))
        }
    }
}