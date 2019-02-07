package com.gladkikh.netreqest

import com.gladkikh.netreqest.entity.Api
import com.gladkikh.netreqest.entity.RsGetDoc
import io.reactivex.Observable


class NetHelper(private val host: String, private val login: String?, private val pass: String?) {

    private lateinit var api: Api

    init {
        api = NetworkingModule(host).provideAPIService()
    }

    fun getObservable(): Observable<RsGetDoc> {
        return api.getDoc(
            AutoritationManager.getStringAutorization(
                login?:"",
                pass?:""
            )
        )
    }

}