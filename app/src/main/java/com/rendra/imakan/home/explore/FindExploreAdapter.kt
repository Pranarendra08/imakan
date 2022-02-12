package com.rendra.imakan.home.explore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.rendra.imakan.R
import com.rendra.imakan.model.FindExplore
import com.rendra.imakan.model.ikanDetail
import com.rendra.imakan.model.ikanHome

class FindExploreAdapter(private var data: List<ikanDetail>,
                         private val listener:(ikanDetail) -> Unit)
    : RecyclerView.Adapter<FindExploreAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FindExploreAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_find_explore, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: FindExploreAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val btnFind:TextView = view.findViewById(R.id.btn_find)

        fun bindItem(data:ikanDetail, listener: (ikanDetail) -> Unit, context: Context) {
            btnFind.setText(data.nama)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

}