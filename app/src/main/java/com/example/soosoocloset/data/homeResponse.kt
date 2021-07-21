package com.example.soosoocloset.data

import com.example.soosoocloset.domain.Home
import com.google.gson.annotations.SerializedName

data class homeResponse(
    @SerializedName("resultArray")
    val resultArray: List<Home>,
    @SerializedName("code")
    val code: String
)