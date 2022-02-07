package com.rendra.imakan.home

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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.rendra.imakan.R
import com.rendra.imakan.model.ikanHome

class HomePictAdapter(private var data: List<ikanHome>,
                      private val listener:(ikanHome) -> Unit)
    : RecyclerView.Adapter<HomePictAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePictAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_home_pict, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: HomePictAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNama:TextView = view.findViewById(R.id.tv_nama_ikan)
        private val tvJarak:TextView = view.findViewById(R.id.tv_jarak)

        private val ivImage:ImageView = view.findViewById(R.id.iv_foto_ikan)

        fun bindItem(data:ikanHome, listener: (ikanHome) -> Unit, context: Context) {
            tvNama.setText(data.nama)
            tvJarak.setText(data.jarak)

            Glide.with(context)
                .load(data.url)
                .into(ivImage)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

}