package com.rendra.imakan.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.home.HomePageActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_login2.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this, HomePageActivity::class.java))
        }
    }
}