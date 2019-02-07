package com.gladkikh.mylibrary

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import io.reactivex.BackpressureStrategy
import io.reactivex.Observer
import io.reactivex.subjects.PublishSubject

class IBarcodeHelper(private val context: AppCompatActivity) : LifecycleObserver,BarcodeHelper {

    private val intent: Intent
    private val mServiceConn: ServiceConnection

    /**
     * get PublishSubject with barcode
     */
    private val barcodePublishSubject = PublishSubject.create<String?>()



    init {
        intent = Intent(context, BrodcastService::class.java)

        mServiceConn = object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?): Unit {

            }

            override fun onServiceConnected(name: ComponentName?, binder: IBinder?): Unit {
                (binder as BrodcastService.MyBinder)
                    .servises.dataPublishSubject
                    .subscribe {
                        barcodePublishSubject.onNext(it!!)
                    }
            }
        }
        context.lifecycle.addObserver(this)
    }

    override fun getDataFlowable() = barcodePublishSubject.toFlowable(BackpressureStrategy.BUFFER)

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onStop() {
        context.unbindService(mServiceConn)
        context.stopService(intent)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        context.startService(intent)
        context.bindService(
            intent,
            mServiceConn,
            AppCompatActivity.BIND_AUTO_CREATE
        )
    }
}