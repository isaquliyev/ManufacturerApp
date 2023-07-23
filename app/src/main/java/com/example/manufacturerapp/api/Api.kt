package com.example.manufacturerapp.api

import com.example.manufacturerapp.model.Manufacturer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("getallmanufacturers?format=json")
    fun getAllManufacturers() : Call<Manufacturer>

    @GET("GetManufacturerDetails/{manufacturerName}?format=json")
    fun getManufacturerByName(@Path("manufacturerName") manufacturerName : String ) : Call<Manufacturer>

    @GET("GetModelsForMakeYear/make/{makeCom}/modelyear/{year}?format=json")
    fun getMakeAndYear(@Path("makeCom") make : String, @Path("year") year : String) : Call<Manufacturer>
}