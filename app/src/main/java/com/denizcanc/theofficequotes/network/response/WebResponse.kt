package com.denizcanc.theofficequotes.network

import com.google.gson.annotations.SerializedName

//
// Created by Deniz Can Çalışkan on 10.10.2021.
//

data class WebResponse(
    @SerializedName("data")
    val data: WebResponseData
)

data class WebResponseData(
    @SerializedName("content")
    val content: String,

    @SerializedName("character")
    val character: WebResponseCharacter,
)

data class WebResponseCharacter(
    @SerializedName("firstname")
    val firstname: String,

    @SerializedName("lastname")
    val lastname: String,
)