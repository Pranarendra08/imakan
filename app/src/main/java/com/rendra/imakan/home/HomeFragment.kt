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
import com.rendra.imakan.model.ikanHome
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference

    private var dataList = ArrayList<ikanHome>()

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
        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("home_ikan")

        tv_nama.setText(preferences.getValue("username"))


        rv_home_pict.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        getData()

    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (getdataSnapshot in snapshot.children) {
                    var ikan = getdataSnapshot.getValue(ikanHome::class.java)
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

}