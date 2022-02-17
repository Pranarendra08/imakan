package com.rendra.imakan.explore

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
import com.rendra.imakan.model.ikanHome

class ExplorePageAdapter(private var data: List<ikanHome>,
                         private val listener:(ikanHome) -> Unit)
    : RecyclerView.Adapter<ExplorePageAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExplorePageAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_home_pict, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ExplorePageAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data:ikanHome, listener: (ikanHome) -> Unit, context: Context) {

        }
    }

}