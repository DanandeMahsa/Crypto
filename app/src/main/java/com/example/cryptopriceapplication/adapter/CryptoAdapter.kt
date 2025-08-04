package com.example.cryptopriceapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cryptopriceapplication.databinding.ItemCoinBinding
import com.example.cryptopriceapplication.model.CryptoEntity
import java.util.Locale

class CryptoAdapter : ListAdapter<CryptoEntity, CryptoAdapter.CryptoViewHolder>(CryptoDiffCallback()) {

    inner class CryptoViewHolder(private val binding: ItemCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CryptoEntity) = with(binding) {
//            ivCoinLoading.visibility = View.VISIBLE
//
//            // Load image with Coil
//            imageViewCoin.load(item.image) {
//                listener(
//                    onSuccess = { _, _ ->
//                        ivCoinLoading.visibility = View.GONE
//                    },
//                    onError = { _, _ ->
//                        ivCoinLoading.visibility = View.GONE
//                    }
//                )
//            }

//            // Load image with Coil using placeholders
//            imageViewCoin.load(item.image) {
//                crossfade(true) // (اختیاری) برای انیمیشن محو شدن نرم
//                placeholder(R.drawable.loading_placeholder) // دایره لودینگ
//                error(R.drawable.ic_error_placeholder) // تصویر خطا
//            }


            tvCoinName.text = item.name
            tvCoinSymbol.text = item.symbol.uppercase(Locale.getDefault())
            tvCoinPrice.text = String.format(Locale.getDefault(), "$%.2f", item.current_price)
            textViewChange24h.text = String.format(Locale.getDefault(), "%.2f%%", item.price_change_percentage_24h)

            // تغییر رنگ درصد
            val color = if (item.price_change_percentage_24h >= 0) {
                android.graphics.Color.GREEN
            } else {
                android.graphics.Color.RED
            }
            textViewChange24h.setTextColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding = ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
