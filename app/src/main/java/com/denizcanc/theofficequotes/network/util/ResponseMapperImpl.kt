package com.denizcanc.theofficequotes.network.util

import com.denizcanc.theofficequotes.model.Quote
import com.denizcanc.theofficequotes.network.WebResponse

//
// Created by Deniz Can Çalışkan on 10.10.2021.
//

class ResponseMapperImpl: ResponseMapper {
    override fun mapResponseToQuote(response: WebResponse): Quote {
        return Quote(
            text = response.data.content,
            author = (response.data.character.firstname + " " + response.data.character.lastname)
        )
    }
}