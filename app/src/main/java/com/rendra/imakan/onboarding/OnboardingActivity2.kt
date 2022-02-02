package com.rendra.imakan.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.signin.SignInActivity
import kotlinx.android.synthetic.main.activity_onboarding2.*

class OnboardingActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)

        btn_lanjut.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}