package com.rendra.imakan.cart.orderConfirmation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rendra.imakan.R
import com.rendra.imakan.model.Order

class CheckoutAdapter(private var datas: ArrayList<Order>,
                      private val listener:(Order) -> Unit)
    : RecyclerView.Adapter<CheckoutAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CheckoutAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_checkout, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: CheckoutAdapter.ViewHolder, position: Int) {
        holder.bindItem(datas[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = datas.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNama:TextView = view.findViewById(R.id.tv_nama_ikan)
        private val tvHarga:TextView = view.findViewById(R.id.tv_harga)

        fun bindItem(datas: Order, listener: (Order) -> Unit, context: Context) {
            tvNama.setText(datas.ikan)
            tvHarga.setText(datas.harga)

            itemView.setOnClickListener {
                listener(datas)
            }
        }
    }

}