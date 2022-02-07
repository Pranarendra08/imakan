package com.rendra.imakan.home

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class HomePictAdapter(private var datab: List<ikanHome>,
                      private val listener:(ikanHome) -> Unit)
    : RecyclerView.Adapter<HomePictAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePictAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomePictAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

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