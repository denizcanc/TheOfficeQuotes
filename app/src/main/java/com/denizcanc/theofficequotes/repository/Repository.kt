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

interface Repository {
    suspend fun getQuote(): Flow<DataState<Quote>>
}