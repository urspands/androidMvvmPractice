package com.raj.androidmvvmpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raj.androidmvvmpractice.databinding.StockItemBinding

class StockListAdapter : RecyclerView.Adapter<StockListAdapter.StockViewHolder>() {
    private var stockList = ArrayList<String>()

    class StockViewHolder(private val stockItemBinding: StockItemBinding) :
        RecyclerView.ViewHolder(stockItemBinding.root) {
        fun bind(name: String) {
            stockItemBinding.stockName.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        return StockViewHolder(
            StockItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return stockList.size
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        holder.bind(stockList[position])
    }

    fun addNames(names: ArrayList<String>) {
        stockList.addAll(names)
        notifyDataSetChanged()
    }
}