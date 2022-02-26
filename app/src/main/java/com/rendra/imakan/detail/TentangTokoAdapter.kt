package com.rendra.imakan.detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rendra.imakan.R
import com.rendra.imakan.home.HomePictAdapter
import com.rendra.imakan.model.TentangToko

class TentangTokoAdapter(private var data: List<TentangToko>,
                         private val listener:(TentangToko) -> Unit)
    : RecyclerView.Adapter<TentangTokoAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TentangTokoAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.item_tentang_toko, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: TentangTokoAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNamaToko:TextView = view.findViewById(R.id.tv_nama_toko)
        private val tvTransaksi:TextView = view.findViewById(R.id.tv_transaksi)
        private val tvAktivitas:TextView = view.findViewById(R.id.tv_aktifitas)

        private val ivPhoto:ImageView = view.findViewById(R.id.iv_photo_toko)

        fun bindItem(data: TentangToko, listener: (TentangToko) -> Unit, context: Context) {
            tvNamaToko.text = data.namaToko
            tvTransaksi.text = data.transaksi
            tvAktivitas.text = data.aktif

            Glide.with(context)
                .load(data.urlToko)
                .apply(RequestOptions.centerCropTransform())
                .into(ivPhoto)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}