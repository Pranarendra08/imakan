package com.rendra.imakan.detail

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
import com.rendra.imakan.R
import com.rendra.imakan.model.TentangToko
import com.rendra.imakan.model.Ulasan

class UlasanAdapter(private var data: List<Ulasan>,
                    private val listener:(Ulasan) -> Unit)
    : RecyclerView.Adapter<UlasanAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UlasanAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.rv_ulasan, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: UlasanAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNama: TextView = view.findViewById(R.id.tv_nama)
        private val tvKomentar: TextView = view.findViewById(R.id.tv_komentar)

        private val ivPhoto: ImageView = view.findViewById(R.id.iv_photo)

        fun bindItem(data: Ulasan, listener: (Ulasan) -> Unit, context: Context) {
            tvNama.text = data.nama
            tvKomentar.text = data.komentar

            Glide.with(context)
                .load(data.url)
                .apply(RequestOptions.centerCropTransform())
                .into(ivPhoto)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }
}