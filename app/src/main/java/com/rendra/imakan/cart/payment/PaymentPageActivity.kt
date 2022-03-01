package com.rendra.imakan.cart.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.imakan.R
import com.rendra.imakan.cart.paymentDetail.PaymentDetailActivity
import kotlinx.android.synthetic.main.activity_payment_page.*

class PaymentPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_page)

        btn_bayar_hide.setOnClickListener {
            startActivity(Intent(this, PaymentDetailActivity::class.java))
        }

    }

}