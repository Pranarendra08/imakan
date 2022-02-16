package com.rendra.imakan.cart.paymentDetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.cart.paymentSuccess.PaymentSuccessPageActivity
import com.rendra.imakan.home.HomePageActivity
import kotlinx.android.synthetic.main.activity_payment_detail.*

class PaymentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_detail)

        btn_konfirmasi.setOnClickListener {
            startActivity(Intent(this, PaymentSuccessPageActivity::class.java))
        }
    }
}