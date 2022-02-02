package com.rendra.imakan.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import kotlinx.android.synthetic.main.activity_onboarding1.*

class OnboardingActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding1)

        btn_lanjut.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this, OnboardingActivity2::class.java))
        }
    }
}