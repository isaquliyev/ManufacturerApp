package com.example.manufacturerapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.manufacturerapp.model.Manufacturer
import com.example.manufacturerapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel : ViewModel() {
    private var detailLiveData = MutableLiveData<Manufacturer>()
    fun getManufacturerByName(manufacturerName : String) {
        RetrofitClient.api.getManufacturerByName(manufacturerName).enqueue(object : Callback<Manufacturer> {
            override fun onResponse(call: Call<Manufacturer>, response: Response<Manufacturer>) {
                if (response.body() != null ) {
                    detailLiveData.value = response.body()
                }
                else {
                    return
                }
            }

            override fun onFailure(call: Call<Manufacturer>, t: Throwable) {
                Log.d("Tag", t.message.toString())
            }
        } )
    }
    fun observeDetailLiveData() : LiveData<Manufacturer> {
        return detailLiveData
    }
}