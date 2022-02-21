package com.rendra.imakan.explore

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
import com.rendra.imakan.R
import com.rendra.imakan.detail.DetailActivity
import com.rendra.imakan.model.FindExplore
import com.rendra.imakan.model.ikanDetail
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.fragment_explore.*
import kotlinx.android.synthetic.main.fragment_explore.iv_photo
import kotlinx.android.synthetic.main.fragment_explore.tv_nama


class ExploreFragment : Fragment() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mDatabase2: DatabaseReference

    private var dataList = ArrayList<FindExplore>()
    private var dataList2 = ArrayList<ikanDetail>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(activity!!.applicationContext)
        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("explore")

        tv_nama.text = preferences.getValue("nama")

        Glide.with(this)
            .load(preferences.getValue("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(iv_photo)

        rv_find_explore.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_explore_image.layoutManager = LinearLayoutManager(context!!.applicationContext)

        getData()
        getData2()
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (getdataSnapshot in snapshot.children) {
                    var ikan = getdataSnapshot.getValue(FindExplore::class.java)
                    dataList.add(ikan!!)
                }

                rv_find_explore.adapter = FindExploreAdapter(dataList) {
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

                rv_explore_image.adapter = ExplorePageAdapter(dataList2) {
                    startActivity(Intent(context, DetailActivity::class.java).putExtra("data", it))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}