package com.denizcanc.theofficequotes.repository

import com.denizcanc.theofficequotes.model.Quote
import com.denizcanc.theofficequotes.network.RetrofitService
import com.denizcanc.theofficequotes.network.util.ResponseMapper
import com.denizcanc.theofficequotes.state.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//
// Created by Deniz Can Çalışkan on 10.10.2021.
//

class Repository @Inject constructor(
    private val retrofitService: RetrofitService,
    private val responseMapper: ResponseMapper
    ) {
    suspend fun getQuote(): Flow<DataState<Quote>> = flow {
        emit(DataState.Loading)
        try {
            val response = retrofitService.getResponse()
            val quote = responseMapper.mapResponseToQuote(response)
            emit(DataState.Success(quote))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}