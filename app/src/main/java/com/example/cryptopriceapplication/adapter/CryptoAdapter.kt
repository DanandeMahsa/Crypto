package com.example.cryptopriceapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptopriceapplication.R
import com.example.cryptopriceapplication.model.CryptoEntity

class CryptoAdapter(private var cryptoList: List<CryptoEntity>) :
    RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    inner class CryptoViewHolder(itemView: android.view.View) :
        RecyclerView.ViewHolder(itemView) {
        val symbolTextView: android.widget.TextView = itemView.findViewById(R.id.symbolTextView)
        val priceTextView: android.widget.TextView = itemView.findViewById(R.id.priceTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.crypto_item, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val item = cryptoList[position]
        holder.symbolTextView.text = item.symbol
        holder.priceTextView.text = item.priceUsd
    }

    override fun getItemCount() = cryptoList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<CryptoEntity>) {
        cryptoList = newData
        notifyDataSetChanged()
    }
}