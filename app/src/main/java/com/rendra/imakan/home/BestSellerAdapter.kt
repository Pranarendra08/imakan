package com.rendra.imakan.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.*
import com.rendra.imakan.R
import com.rendra.imakan.model.ikanDetail
import com.rendra.imakan.model.ikanHome
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.rv_rekomendasi_best.*


class BestSellerAdapter(private var data: List<ikanDetail>,
                         private val listener:(ikanDetail) -> Unit)
    : RecyclerView.Adapter<BestSellerAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.rv_rekomendasi_best, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: BestSellerAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvIkan:TextView = view.findViewById(R.id.tv_ikan)
        private val tvHarga:TextView = view.findViewById(R.id.tv_harga)
        private val tvTersedia:TextView = view.findViewById(R.id.tv_tersedia)
        private val tvJarak:TextView = view.findViewById(R.id.tv_jarak)
        private val tvToko:TextView = view.findViewById(R.id.tv_toko)
        private val tvRate:TextView = view.findViewById(R.id.tv_rating)

        private val ivPhoto:ImageView = view.findViewById(R.id.iv_best_seller)

        fun bindItem(data: ikanDetail, listener: (ikanDetail) -> Unit, context: Context) {
            tvIkan.text = data.nama
            tvHarga.text = data.harga
            tvTersedia.text = data.tersedia
            tvJarak.text = data.jarak
            tvToko.text = data.toko
            tvRate.text = data.rating

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