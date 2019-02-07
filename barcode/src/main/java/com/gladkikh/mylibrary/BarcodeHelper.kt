package com.gladkikh.mylibrary

import io.reactivex.Flowable

interface BarcodeHelper {
    public fun getDataFlowable():Flowable<String?>
}