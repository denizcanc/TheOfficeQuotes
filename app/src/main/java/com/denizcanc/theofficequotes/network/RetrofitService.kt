package com.denizcanc.theofficequotes.network

import retrofit2.http.GET

//
// Created by Deniz Can Çalışkan on 10.10.2021.
//

interface RetrofitService {
    @GET("quotes/random/")
    suspend fun getResponse(): WebResponse
}