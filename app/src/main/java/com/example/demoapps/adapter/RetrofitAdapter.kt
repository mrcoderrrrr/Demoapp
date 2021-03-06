package com.example.demoapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapps.R
import com.example.demoapps.model.RetrofitModel

class RetrofitAdapter(context: Context, private var apiData: ArrayList<RetrofitModel>) :
    RecyclerView.Adapter<RetrofitAdapter.ViewHolder>() {
    private val context: Context

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.retrofit_data_cardview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // retrofitdata
            holder.date.setText(apiData.get(position).data.list_data[position].date).toString()
            holder.height.setText(apiData.get(position).data.list_data[position].heigh).toString()
            holder.diffrence.setText(apiData.get(position).data.list_data[position].difference.toString())
            if (apiData.get(position).data.list_data[position].is_increased == true) {
                holder.arrow.visibility = View.VISIBLE
            } else {
                holder.arrow.visibility = View.INVISIBLE
            }
    }

    override fun getItemCount(): Int {
        return apiData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date: TextView
        var height: TextView
        var diffrence: TextView
        var arrow: ImageView

        init {
            date = itemView.findViewById(R.id.tv_apiDate)
            height = itemView.findViewById(R.id.tv_apiHeight)
            diffrence = itemView.findViewById(R.id.tv_apiDiffrence)
            arrow = itemView.findViewById(R.id.iv_arrow)
        }
    }
}