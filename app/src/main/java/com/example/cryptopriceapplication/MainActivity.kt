package com.example.cryptopriceapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptopriceapplication.adapter.CryptoAdapter
import dagger.hilt.android.AndroidEntryPoint
import android.widget.Button
import androidx.lifecycle.ViewModelProvider

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CryptoViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.cryptoRecyclerView)
        btnUpdate = findViewById(R.id.btnUpdate)
        val cryptoAdapter = CryptoAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = cryptoAdapter
//viewModel= CryptoViewModel()
        viewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)
        viewModel.cryptoList.observe(this) { cryptos ->
            cryptoAdapter.updateData(cryptos)
        }
        btnUpdate.setOnClickListener {
            viewModel.updateFromApi()
        }
        viewModel.loadFromDatabase()
    }
}