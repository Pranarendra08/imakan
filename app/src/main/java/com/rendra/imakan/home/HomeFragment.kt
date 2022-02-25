package com.rendra.imakan.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.*
import com.rendra.imakan.detail.DetailActivity
import com.rendra.imakan.R
import com.rendra.imakan.model.ikanDetail
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mDatabase2: DatabaseReference
    private lateinit var mDatabase3: DatabaseReference
    private lateinit var mDatabase4: DatabaseReference

    private var dataList = ArrayList<ikanDetail>()
    private var dataList2 = ArrayList<ikanDetail>()
    private var dataList3 = ArrayList<ikanDetail>()
    private var dataList4 = ArrayList<ikanDetail>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(activity!!.applicationContext)
        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("ikan")
            .child("home")
        mDatabase2 = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("ikan")
            .child("BestSeller")
        mDatabase3 = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("ikan")
            .child("rekomendasi")
        mDatabase4 = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("ikan")
            .child("BeliLagi")

        tv_nama.text = preferences.getValue("nama")

        Glide.with(this)
            .load(preferences.getValue("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(imageView2)

        rv_home_pict.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_bestseller.layoutManager = LinearLayoutManager(context!!.applicationContext)
        rv_rekomendasi.layoutManager = LinearLayoutManager(context!!.applicationContext)
        rv_beli_lagi.layoutManager = LinearLayoutManager(context!!.applicationContext)

        getData()
        getData2()
        getData3()
        getData4()

    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (getdataSnapshot in snapshot.children) {
                    var ikan = getdataSnapshot.getValue(ikanDetail::class.java)
                    dataList.add(ikan!!)
                }
                rv_home_pict.adapter = HomePictAdapter(dataList) {
                    var intent = Intent(context, DetailActivity::class.java).putExtra("data", it)
                    startActivity(intent)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun getData2() {
        mDatabase2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList2.clear()
                for (getdataSnapshot in snapshot.children) {
                    var ikan = getdataSnapshot.getValue(ikanDetail::class.java)
                    dataList2.add(ikan!!)
                }
                rv_bestseller.adapter = HomeSellerAdapter(dataList2) {
                    startActivity(Intent(context, DetailActivity::class.java).putExtra("data", it))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun getData3() {
        mDatabase3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList3.clear()
                for (getdataSnapshot in snapshot.children) {
                    var ikan = getdataSnapshot.getValue(ikanDetail::class.java)
                    dataList3.add(ikan!!)
                }
                rv_rekomendasi.adapter = HomeSellerAdapter(dataList3) {
                    startActivity(Intent(context, DetailActivity::class.java).putExtra("data", it))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun getData4() {
        mDatabase4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList4.clear()
                for (getdataSnapshot in snapshot.children) {
                    var ikan = getdataSnapshot.getValue(ikanDetail::class.java)
                    dataList4.add(ikan!!)
                }
                rv_beli_lagi.adapter = HomeSellerAdapter(dataList4) {
                    startActivity(Intent(context, DetailActivity::class.java).putExtra("data", it))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

}