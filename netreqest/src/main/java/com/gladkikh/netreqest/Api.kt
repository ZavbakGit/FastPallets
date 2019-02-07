package com.gladkikh.netreqest.entity

import io.reactivex.Observable
import retrofit2.http.*

interface Api {
    @GET("/RMMT/hs/pals/DocList/1")
    fun getDoc(@Header("Authorization") auth: String): Observable<RsGetDoc>
}