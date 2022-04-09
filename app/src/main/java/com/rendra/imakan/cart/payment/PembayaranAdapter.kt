package com.rendra.imakan.cart.payment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rendra.imakan.R
import com.rendra.imakan.model.Pembayaran

class PembayaranAdapter(private var datas: ArrayList<Pembayaran>,
                        private val listener:(Pembayaran) -> Unit)
    : RecyclerView.Adapter<PembayaranAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PembayaranAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_checkout, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: PembayaranAdapter.ViewHolder, position: Int) {
        holder.bindItem(datas[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = datas.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNama:TextView = view.findViewById(R.id.tv_nama)

        private val ivPembayaran:ImageView = view.findViewById(R.id.iv_pembayaran)

        fun bindItem(datas: Pembayaran, listener: (Pembayaran) -> Unit, context: Context) {
            tvNama.setText(datas.nama)

            Glide.with(context)
                .load(datas.url)
                .into(ivPembayaran)

            itemView.setOnClickListener {
                listener(datas)
            }
        }
    }

}