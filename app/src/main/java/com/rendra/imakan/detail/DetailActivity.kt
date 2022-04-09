package com.rendra.imakan.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.*
import com.rendra.imakan.R
import com.rendra.imakan.cart.orderConfirmation.OrderConfirmationActivity
import com.rendra.imakan.model.Order
import com.rendra.imakan.model.TentangToko
import com.rendra.imakan.model.Ulasan
import com.rendra.imakan.model.ikanDetail
import kotlinx.android.synthetic.main.activity_detail.*
import kotlin.collections.ArrayList

class DetailActivity : AppCompatActivity() {

    private lateinit var mDatabase: DatabaseReference
    private lateinit var mDatabase2: DatabaseReference
    private var dataList = ArrayList<TentangToko>()
    private var dataList2 = ArrayList<Ulasan>()
    private var dataList3 = ArrayList<Order>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<ikanDetail>("data")

        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("ikan")
            .child(data?.nama.toString())
            .child("toko")
        mDatabase2 = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("ikan")
            .child(data?.nama.toString())
            .child("ulasan")

        tv_total_desc.text = data!!.nama
        tv_nama.text = data.harga

        Glide.with(this)
            .load(data.url)
            .apply(RequestOptions.centerCropTransform())
            .into(iv_poster)

        rv_tentang_toko.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_ulasan.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        getData()
        getData2()

        val ikan = Order(data.nama, data.harga)
        dataList3.add(ikan)

        btn_beli.setOnClickListener {
            startActivity(Intent(this, OrderConfirmationActivity::class.java).putExtra("data", dataList3).putExtra("datas", data))
        }
    }


    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (getSnapshot in snapshot.children) {
                    var toko = getSnapshot.getValue(TentangToko::class.java)
                    dataList.add(toko!!)
                }

                rv_tentang_toko.adapter = TentangTokoAdapter(dataList) {

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DetailActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun getData2() {
        mDatabase2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList2.clear()
                for (getSnapshot in snapshot.children) {
                    var ulasan = getSnapshot.getValue(Ulasan::class.java)
                    dataList2.add(ulasan!!)
                }

                rv_ulasan.adapter = UlasanAdapter(dataList2) {

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DetailActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}