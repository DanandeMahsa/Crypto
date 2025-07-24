package com.example.cryptopriceapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptopriceapplication.adapter.CryptoAdapter
import com.example.cryptopriceapplication.databinding.ActivityMainBinding // این خط را اضافه کنید

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CryptoViewModel
    private val cryptoAdapter = CryptoAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[CryptoViewModel::class.java]


        setupRecyclerView()
        observeViewModel()

    }

    private fun setupRecyclerView() {
        binding.cryptoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = cryptoAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.cryptoList.observe(this) { cryptos ->

            cryptoAdapter.updateData(cryptos)
        }


        viewModel.isLoading.observe(this) { isLoading ->

        }
    }
}