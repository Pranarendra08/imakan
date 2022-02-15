package com.rendra.imakan.profile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.signin.SignInActivity
import kotlinx.android.synthetic.main.activity_account_settings.*

class AccountSettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_settings)

        tv_logout.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}