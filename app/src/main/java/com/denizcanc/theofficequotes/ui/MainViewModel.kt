package com.denizcanc.theofficequotes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denizcanc.theofficequotes.model.Quote
import com.denizcanc.theofficequotes.repository.Repository
import com.denizcanc.theofficequotes.state.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

//
// Created by Deniz Can Çalışkan on 10.10.2021.
//

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    ): ViewModel() {
    private val _dataState: MutableLiveData<DataState<Quote>> = MutableLiveData()

    val dataState: LiveData<DataState<Quote>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetQuoteEvent -> {
                    repository.getQuote()
                        .collect {
                            _dataState.value = it
                        }
                }
            }
        }
    }
}

sealed class MainStateEvent{
    object GetQuoteEvent: MainStateEvent()
    //can add more events later if needed
}