package com.rendra.imakan.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.*
import com.rendra.imakan.R
import com.rendra.imakan.model.TentangToko
import com.rendra.imakan.model.ikanDetail
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*
import kotlin.collections.ArrayList

class DetailActivity : AppCompatActivity() {

    private lateinit var mDatabase: DatabaseReference
    private var dataList = ArrayList<TentangToko>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<ikanDetail>("data")

        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("ikan")
            .child(data?.nama.toString())
            .child("toko")

        tv_nama_ikan.text = data!!.nama
        tv_harga.text = data.harga

        Glide.with(this)
            .load(data.url)
            .apply(RequestOptions.centerCropTransform())
            .into(iv_poster)

        rv_tentang_toko.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getData()
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
}