package com.rendra.imakan.cart.orderConfirmation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.rendra.imakan.R
import com.rendra.imakan.cart.payment.PaymentPageActivity
import com.rendra.imakan.detail.TentangTokoAdapter
import com.rendra.imakan.model.Order
import com.rendra.imakan.model.TentangToko
import com.rendra.imakan.model.ikanDetail
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_order_confirmation.*

class OrderConfirmationActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference
    private var dataList = ArrayList<Order>()

    private var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirmation)

        preferences = Preferences(this)
        dataList = intent.getSerializableExtra("data") as ArrayList<Order>
        val ikan = intent.getParcelableArrayListExtra<ikanDetail>("datas")

        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("ikan")
            .child(ikan.toString())

        tv_nama.text = preferences.getValue("nama")
        tv_phone_number.text = preferences.getValue("phoneNumber")
        tv_alamat.text = preferences.getValue("alamat")

        for (a in dataList.indices) {
            total += dataList[a].harga!!.toInt()
        }

        dataList.add(Order("Biaya Ongkos Kirim: JNE", "Rp. 28,000"))
        total += 28000
        dataList.add(Order("Potongan dari voucher", "Rp. 0"))
        dataList.add(Order("Total yang harus dibayarkan", total.toString()))

        rv_total_pembayaran.layoutManager = LinearLayoutManager(this)
        rv_total_pembayaran.adapter = CheckoutAdapter(dataList) {

        }

        rv_keranjang.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        btn_lanjut_bayar.setOnClickListener {
            startActivity(Intent(this, PaymentPageActivity::class.java).putExtra("data", dataList))
        }
    }

}