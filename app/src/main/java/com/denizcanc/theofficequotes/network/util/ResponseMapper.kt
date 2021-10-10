package com.denizcanc.theofficequotes.network.util

import com.denizcanc.theofficequotes.model.Quote
import com.denizcanc.theofficequotes.network.WebResponse

//
// Created by Deniz Can Çalışkan on 10.10.2021.
//

interface ResponseMapper  {
    fun mapResponseToQuote(response: WebResponse): Quote
}