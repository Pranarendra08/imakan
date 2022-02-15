package com.rendra.imakan.cart.orderConfirmation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.cart.payment.PaymentPageActivity
import kotlinx.android.synthetic.main.activity_order_confirmation.*

class OrderConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirmation)

        btn_lanjut_bayar.setOnClickListener {
            startActivity(Intent(this, PaymentPageActivity::class.java))
        }
    }
}