package com.rendra.imakan.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.*
import com.rendra.imakan.R
import com.rendra.imakan.model.ikanDetail
import com.rendra.imakan.utils.Preferences

class DetailPageFragment : Fragment() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference

    private var dataList = ArrayList<ikanDetail>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        preferences = Preferences(activity!!.applicationContext)
        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("home_ikan")


        getdata()
    }

    private fun getdata() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (getDataSnapshot in snapshot.children) {
                    var ikan = getDataSnapshot.getValue(ikanDetail::class.java)
                    dataList.add(ikan!!)
                }


            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}