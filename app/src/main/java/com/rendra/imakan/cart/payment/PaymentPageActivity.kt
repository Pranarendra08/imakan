package com.rendra.imakan.cart.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DatabaseReference
import com.rendra.imakan.R
import com.rendra.imakan.cart.orderConfirmation.CheckoutAdapter
import com.rendra.imakan.cart.paymentDetail.PaymentDetailActivity
import com.rendra.imakan.model.Order
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.activity_order_confirmation.*
import kotlinx.android.synthetic.main.activity_payment_page.*
import kotlinx.android.synthetic.main.activity_payment_page.rv_total_pembayaran

class PaymentPageActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference
    private var dataList = ArrayList<Order>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_page)

        preferences = Preferences(this)
        dataList = intent.getSerializableExtra("data") as ArrayList<Order>
        val total = intent.getSerializableExtra("total")
        tv_total_harus_dibayar2.text = total.toString()

        rv_total_pembayaran.layoutManager = LinearLayoutManager(this)
        rv_total_pembayaran.adapter = CheckoutAdapter(dataList) {

        }




        btn_bayar_hide.setOnClickListener {
            startActivity(Intent(this, PaymentDetailActivity::class.java))
        }

    }

}