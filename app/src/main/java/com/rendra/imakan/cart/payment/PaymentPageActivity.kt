package com.rendra.imakan.cart.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.rendra.imakan.R
import com.rendra.imakan.cart.orderConfirmation.CheckoutAdapter
import com.rendra.imakan.cart.paymentDetail.PaymentDetailActivity
import com.rendra.imakan.model.Order
import com.rendra.imakan.model.Pembayaran
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.activity_order_confirmation.*
import kotlinx.android.synthetic.main.activity_payment_page.*
import kotlinx.android.synthetic.main.activity_payment_page.rv_total_pembayaran

class PaymentPageActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mDatabase2: DatabaseReference
    private var dataList = ArrayList<Order>()
    private var dataList2 = ArrayList<Pembayaran>()
    private var dataList3 = ArrayList<Pembayaran>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_page)

        preferences = Preferences(this)
        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("pembayaran")
            .child("bank")
        mDatabase2 = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("pembayaran")
            .child("minimarket")

        dataList = intent.getSerializableExtra("data") as ArrayList<Order>
        val total = intent.getSerializableExtra("total")

        tv_total_harus_dibayar2.text = total.toString()

        rv_total_pembayaran.layoutManager = LinearLayoutManager(this)
        rv_total_pembayaran.adapter = CheckoutAdapter(dataList) {

        }

        rv_transfer_bank.layoutManager = LinearLayoutManager(this.applicationContext)
        rv_minimarket.layoutManager = LinearLayoutManager(this.applicationContext)

        getData1()


        btn_bayar_hide.setOnClickListener {
            startActivity(Intent(this, PaymentDetailActivity::class.java))
        }

    }

    private fun getData1() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList2.clear()
                for (getSnapshot in snapshot.children) {
                    var pembayaran = getSnapshot.getValue(Pembayaran::class.java)
                    dataList2.add(pembayaran!!)
                }
                rv_transfer_bank.adapter = PembayaranAdapter(dataList2) {

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@PaymentPageActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }

        })
    }

}