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
import com.rendra.imakan.model.ikanDetail

class ExplorePageAdapter(private var data: List<ikanDetail>,
                         private val listener:(ikanDetail) -> Unit)
    : RecyclerView.Adapter<ExplorePageAdapter.ViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExplorePageAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_explore_page, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ExplorePageAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvIkan1:TextView = view.findViewById(R.id.tv_total_desc)
        private val tvIkan2:TextView = view.findViewById(R.id.tv_nama_ikan2)
        private val tvIkan3:TextView = view.findViewById(R.id.tv_nama_ikan3)
        private val tvIkan4:TextView = view.findViewById(R.id.tv_nama_ikan4)

        private val tvHarga1:TextView = view.findViewById(R.id.tv_nama)
        private val tvHarga2:TextView = view.findViewById(R.id.tv_harga2)
        private val tvHarga3:TextView = view.findViewById(R.id.tv_harga3)
        private val tvHarga4:TextView = view.findViewById(R.id.tv_harga4)

        private val ivPhoto1:ImageView = view.findViewById(R.id.iv_foto_ikan)
        private val ivPhoto2:ImageView = view.findViewById(R.id.iv_foto_ikan2)
        private val ivPhoto3:ImageView = view.findViewById(R.id.iv_foto_ikan3)
        private val ivPhoto4:ImageView = view.findViewById(R.id.iv_foto_ikan4)

        fun bindItem(data:ikanDetail, listener: (ikanDetail) -> Unit, context: Context) {
            tvIkan1.text = data.nama
            tvIkan2.text = data.nama
            tvIkan3.text = data.nama
            tvIkan4.text = data.nama

            tvHarga1.text = data.harga
            tvHarga2.text = data.harga
            tvHarga3.text = data.harga
            tvHarga4.text = data.harga

            Glide.with(context)
                .load(data.url)
                .apply(RequestOptions.centerCropTransform())
                .into(ivPhoto1)

            Glide.with(context)
                .load(data.url)
                .apply(RequestOptions.centerCropTransform())
                .into(ivPhoto2)

            Glide.with(context)
                .load(data.url)
                .apply(RequestOptions.centerCropTransform())
                .into(ivPhoto3)

            Glide.with(context)
                .load(data.url)
                .apply(RequestOptions.centerCropTransform())
                .into(ivPhoto4)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

}