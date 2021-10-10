package com.denizcanc.theofficequotes.di

import com.denizcanc.theofficequotes.network.RetrofitService
import com.denizcanc.theofficequotes.network.util.ResponseMapper
import com.denizcanc.theofficequotes.repository.Repository
import com.denizcanc.theofficequotes.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//
// Created by Deniz Can Çalışkan on 10.10.2021.
//

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(
        retrofit: RetrofitService,
        mapper: ResponseMapper
    ): Repository {
        return RepositoryImpl(retrofit, mapper)
    }
}