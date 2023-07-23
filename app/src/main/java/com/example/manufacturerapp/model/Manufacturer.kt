package com.example.manufacturerapp.model

import java.io.Serializable

data class Manufacturer(val Results : List<Result>) : Serializable

data class Result(
    val Country : String,
    val Mfr_CommonName : String,
    val Mfr_ID : Int,
    val Mfr_Name : String,
    val VehicleTypes : List<VehicleTypes>,
    val Address : String,
    val Address2 : String,
    val City : String,
    val ContactEmail : String,
    val ContactFax : String,
    val ContactPhone : String,
    val PrincipialFirstName : String,
    val Make_Name : String,
    val Model_Name : String
) : Serializable

data class VehicleTypes(
    val IsPrimary : Boolean,
    val Name : String
) : Serializable


