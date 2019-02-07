package com.gladkikh.netreqest


import com.gladkikh.netreqest.entity.Api
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory


class NetworkingModule(val baseUrl: String) {

    var retrofit: Retrofit

    init {
        retrofit = provideRestAdapter()
    }

    private fun provideRestAdapter(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl) //Базовая часть адреса
            .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun provideAPIService(): Api {
        return retrofit.create(Api::class.java)
    }
}
