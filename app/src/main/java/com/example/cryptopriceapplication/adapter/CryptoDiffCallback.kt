package com.example.cryptopriceapplication.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptopriceapplication.model.CryptoEntity

class CryptoDiffCallback : DiffUtil.ItemCallback<CryptoEntity>() {
    override fun areItemsTheSame(oldItem: CryptoEntity, newItem: CryptoEntity): Boolean {
        return oldItem.symbol == newItem.symbol
    }
    override fun areContentsTheSame(oldItem: CryptoEntity, newItem: CryptoEntity): Boolean {
        return oldItem == newItem
    }
}