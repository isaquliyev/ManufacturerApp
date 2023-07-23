package com.example.manufacturerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.manufacturerapp.databinding.ActivityDetailBinding
import com.example.manufacturerapp.model.Result

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    lateinit var result: Result
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        result = intent.getSerializableExtra("Detail") as Result
        binding.address1Id.setText(result.Address)
        binding.cityId.setText(result.City)
        binding.countryId.setText(result.Country)
        binding.mfrCommonNameId.setText(result.Mfr_CommonName)
        binding.mfrName2ID.setText(result.Mfr_Name)

    }
}