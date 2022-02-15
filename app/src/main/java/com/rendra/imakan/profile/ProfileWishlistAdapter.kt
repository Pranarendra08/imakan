package com.rendra.imakan.profile

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

class ProfileWishlistAdapter(private var data: List<ikanHome>,
                             private val listener:(ikanHome) -> Unit)
    : RecyclerView.Adapter<ProfileWishlistAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileWishlistAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_home_pict, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ProfileWishlistAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNama:TextView = view.findViewById(R.id.tv_nama_ikan)
        private val tvJarak:TextView = view.findViewById(R.id.tv_harga)

        private val ivImage:ImageView = view.findViewById(R.id.iv_foto_ikan)

        fun bindItem(data:ikanHome, listener: (ikanHome) -> Unit, context: Context) {
            tvNama.setText(data.nama)
            tvJarak.setText(data.jarak)

            Glide.with(context)
                .load(data.url)
                .apply(RequestOptions.fitCenterTransform())
                .into(ivImage)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

}