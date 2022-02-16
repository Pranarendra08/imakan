package com.rendra.imakan.cart.paymentSuccess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.home.HomePageActivity
import kotlinx.android.synthetic.main.activity_payment_success_page.*

class PaymentSuccessPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_success_page)

        btn_selesai.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this, HomePageActivity::class.java))
        }
    }
}