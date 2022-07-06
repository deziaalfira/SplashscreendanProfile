package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ListItemBinding
import com.example.recyclerview.model.Presiden

class AdapterPresiden(private val  context : Context,
                      private var data : List<Presiden>?,
                      private val  itemclick : OnClikListener)
                      : RecyclerView.Adapter<AdapterPresiden.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama
        holder.periode

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?:0

    inner class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var nama = binding.txtnama
        var periode = binding.txtnama
    }

    interface OnClikListener {
        fun detailData(item : Presiden?)
    }

}
