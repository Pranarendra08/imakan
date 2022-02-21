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
import com.rendra.imakan.model.ikanHome

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
        private val tvIkan1:TextView = view.findViewById(R.id.tv_nama_ikan)
        private val tvIkan2:TextView = view.findViewById(R.id.tv_nama_ikan2)
        private val tvIkan3:TextView = view.findViewById(R.id.tv_nama_ikan3)
        private val tvIkan4:TextView = view.findViewById(R.id.tv_nama_ikan4)

        private val tvHarga1:TextView = view.findViewById(R.id.tv_harga)
        private val tvHarga2:TextView = view.findViewById(R.id.tv_harga2)
        private val tvHarga3:TextView = view.findViewById(R.id.tv_harga3)
        private val tvHarga4:TextView = view.findViewById(R.id.tv_harga4)

        private val ivPhoto1:TextView = view.findViewById(R.id.iv_foto_ikan)
        private val ivPhoto2:TextView = view.findViewById(R.id.iv_foto_ikan2)
        private val ivPhoto3:TextView = view.findViewById(R.id.iv_foto_ikan3)
        private val ivPhoto4:TextView = view.findViewById(R.id.iv_foto_ikan4)

        fun bindItem(data:ikanDetail, listener: (ikanDetail) -> Unit, context: Context) {

        }
    }

}