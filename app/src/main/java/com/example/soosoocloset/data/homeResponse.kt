package com.example.soosoocloset.data

import com.example.soosoocloset.domain.Home
import com.google.gson.annotations.SerializedName

data class homeResponse(
    @SerializedName("codi")
    val codi: List<Map<*, *>>,
    @SerializedName("code")
    val code: String
)