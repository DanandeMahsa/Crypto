package com.example.cryptopriceapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.cryptopriceapplication.adapter.CryptoAdapter
import com.example.cryptopriceapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CryptoViewModel
    private val cryptoAdapter = CryptoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)

        setupUI()
        observeViewModel()
    }

    private fun setupUI() {
        binding.cryptoRecyclerView.adapter = cryptoAdapter
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                // Add .root to access the actual view from the included layout
                binding.loadingView.root.visibility = View.VISIBLE
                binding.contentGroup.visibility = View.GONE
            } else {
                // Add .root here as well
                binding.loadingView.root.visibility = View.GONE
                binding.contentGroup.visibility = View.VISIBLE
            }
        }

        viewModel.cryptoListLive.observe(this) { cryptoList ->
            cryptoAdapter.submitList(cryptoList)
        }
    }
}