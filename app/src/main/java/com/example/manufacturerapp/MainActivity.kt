package com.example.manufacturerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.manufacturerapp.adapter.ManufacturerAdapter
import com.example.manufacturerapp.adapter.OnItemClickListener
import com.example.manufacturerapp.adapter.SearchListAdapter
import com.example.manufacturerapp.databinding.ActivityMainBinding
import com.example.manufacturerapp.model.Manufacturer
import com.example.manufacturerapp.model.Result
import com.example.manufacturerapp.viewmodel.ManufacturerViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModelManufacturer: ManufacturerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModelManufacturer = ViewModelProvider(this)[ManufacturerViewModel::class.java]
        viewModelManufacturer.getAllManufacturers()
        viewModelManufacturer.observeManufacturerLiveData().observe(this, Observer { manufacturer ->
            onPressButton(manufacturer)
            binding.recyclerView.adapter = ManufacturerAdapter(manufacturer.Results)


        })
        SearchYearAndName()
    }

    override fun onResume() {
        super.onResume()
        viewModelManufacturer.getManufacturerByName(binding.searchBar.text.toString())
    }

    fun onPressButton(manufacturer: Manufacturer) {
        binding.searchButton.setOnClickListener {
            if (binding.searchBar.text.toString() == "") {
                viewModelManufacturer.getAllManufacturers()
            } else {
                viewModelManufacturer.getManufacturerByName(binding.searchBar.text.toString())
                viewModelManufacturer.observeManufacturerLiveData()
                    .observe(this, Observer { manufacturer ->
                        binding.recyclerView.adapter =
                            SearchListAdapter(manufacturer.Results, object : OnItemClickListener {
                                override fun onItemClick(item: Result) {
                                    val intent =
                                        Intent(this@MainActivity, DetailActivity::class.java)
                                    intent.putExtra("Detail", item)
                                    startActivity(intent)
                                }
                            })
                    })

            }

        }
    }

    fun SearchYearAndName() {
        binding.searchForNameYearButton.setOnClickListener {
            val intent = Intent(this@MainActivity, YearAndNameActivity::class.java)
            startActivity(intent)
        }
    }
}