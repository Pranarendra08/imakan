package com.rendra.imakan.detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
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
        return TentangTokoAdapter.ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: TentangTokoAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(tentangToko: TentangToko, listener: (TentangToko) -> Unit, contextAdapter: Context) {
            TODO("Not yet implemented")
        }

    }

}