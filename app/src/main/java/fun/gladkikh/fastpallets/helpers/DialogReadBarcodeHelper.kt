package `fun`.gladkikh.fastpallets.helpers
import `fun`.gladkikh.fastpallets.ui.dialog.ReadBarcodeDialogFg
import android.support.v7.app.AppCompatActivity


class DialogReadBarcodeHelper(val activity: AppCompatActivity) {
    fun showDialog() {
        val manager = activity.supportFragmentManager
        val myDialogFragment = ReadBarcodeDialogFg()
        //val transaction = manager.beginTransaction()
        myDialogFragment.show(manager, "ReadBarcodeDialogFg")
    }
}