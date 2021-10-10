package com.denizcanc.theofficequotes.state

//
// Created by Deniz Can Çalışkan on 10.10.2021.
//

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}