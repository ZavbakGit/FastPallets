package com.gladkikh.dialogreadbarcode

import android.support.v7.app.AppCompatActivity
import com.gladkikh.dialogreadbarcode.mvp.view.ReadBarcodeDialogFg

class DialogReadBarcodeHelper(val activity: AppCompatActivity) {
    fun showDialog() {
        val manager = activity.supportFragmentManager
        val myDialogFragment = ReadBarcodeDialogFg()
        //val transaction = manager.beginTransaction()
        myDialogFragment.show(manager, "ReadBarcodeDialogFg")
    }
}