package `fun`.gladkikh.fastpallets.mvp.presenters

import `fun`.gladkikh.fastpallets.mvp.view.TestActivityView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.subjects.PublishSubject


@InjectViewState
class TestActivityPresenter:MvpPresenter<TestActivityView>() {

    public var count:Int = 0
    public val barcodePublishSubject = PublishSubject.create<String?>()
    public var list = mutableListOf<String?>()


    fun setCount(toInt: Int?) {
        count = count + toInt!!
    }

    fun onScanBarcode(barcode:String?){
        barcodePublishSubject.onNext(barcode!!)
    }

    fun addBarcode(barcode: String) {
        list.add(barcode)
    }

}