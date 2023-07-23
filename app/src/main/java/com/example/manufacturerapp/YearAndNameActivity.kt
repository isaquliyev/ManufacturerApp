package com.example.manufacturerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.manufacturerapp.adapter.MakeAndYearAdapter
import com.example.manufacturerapp.databinding.ActivityYearAndNameBinding
import com.example.manufacturerapp.viewmodel.ManufacturerViewModel

class YearAndNameActivity : AppCompatActivity() {
    lateinit var binding : ActivityYearAndNameBinding
    lateinit var viewModel : ManufacturerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYearAndNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.makeAndYearRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProvider(this)[ManufacturerViewModel::class.java]
        onPressSearchButton()
        viewModel.observeManufacturerLiveData().observe(this, Observer { manufacturer ->
            binding.makeAndYearRecyclerView.adapter = MakeAndYearAdapter(manufacturer.Results)
        })
    }

    fun onPressSearchButton() {
        binding.button.setOnClickListener {
            viewModel.getMakeAndYear(binding.SearchNameId.text.toString(), binding.editTextNumber.text.toString())
        }

    }
}