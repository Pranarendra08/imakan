package com.rendra.imakan.cart.orderConfirmation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rendra.imakan.R
import com.rendra.imakan.model.ikanDetail

class KeranjangAdapter(private var data: List<ikanDetail>,
                       private val listener:(ikanDetail) -> Unit)
    : RecyclerView.Adapter<KeranjangAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KeranjangAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_keranjang, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: KeranjangAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNama:TextView = view.findViewById(R.id.tv_nama)
        private val tvHarga:TextView = view.findViewById(R.id.tv_total)

        private val ivPhoto:ImageView = view.findViewById(R.id.iv_photo_toko)

        fun bindItem(data: ikanDetail, listener: (ikanDetail) -> Unit, context: Context) {
            tvNama.text = data.nama
            tvHarga.text = data.harga

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