package com.gladkikh.dialogreadbarcode.mvp.view


import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.gladkikh.dialogreadbarcode.R
import com.gladkikh.dialogreadbarcode.mvp.presenter.DialogPresenter


class ReadBarcodeDialogFg: MvpAppCompatDialogFragment(),DialogView {

    @InjectPresenter
    lateinit var presenter: DialogPresenter

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)
        // Get the layout inflater
        val inflater = activity!!.layoutInflater

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.barcode_dialog_fg, null))
            // Add action buttons
            .setPositiveButton("signin", { dialog, id -> })
            .setNegativeButton("cancel", { dialog, id -> this@ReadBarcodeDialogFg.getDialog().cancel()})
        return builder.create()
    }
}