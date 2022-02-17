package com.rendra.imakan.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.signin.SignInActivity
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.activity_onboarding1.*

class OnboardingActivity1 : AppCompatActivity() {

    lateinit var preference: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding1)

        preference = Preferences(this)

        if (preference.getValue("onboarding").equals("1")) {
            finishAffinity()

            startActivity(Intent(this, SignInActivity::class.java))
        }

        btn_lanjut.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this, OnboardingActivity2::class.java))
        }
    }
}