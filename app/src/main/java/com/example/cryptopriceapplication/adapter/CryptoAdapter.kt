package com.example.cryptopriceapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptopriceapplication.databinding.CryptoItemBinding // این خط را اضافه کن
import com.example.cryptopriceapplication.model.Crypto


class CryptoAdapter(private var cryptoList: List<Crypto>) :
    RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {


    inner class CryptoViewHolder(private val binding: CryptoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Crypto) {
            binding.symbolTextView.text = item.symbol

            binding.priceTextView.text = "$${item.current_price}"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding = CryptoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(cryptoList[position])
    }

    override fun getItemCount() = cryptoList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<Crypto>?) {

        if (newData != null) {
            this.cryptoList = newData
            notifyDataSetChanged()
        }
    }
}