package `fun`.gladkikh.fastpallets.ui.dialog


import `fun`.gladkikh.fastpallets.R
import `fun`.gladkikh.fastpallets.TestActivity
import `fun`.gladkikh.fastpallets.mvp.presenters.DialogPresenter
import `fun`.gladkikh.fastpallets.mvp.presenters.DialogView
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.barcode_dialog_fg.view.*


class ReadBarcodeDialogFg : MvpAppCompatDialogFragment(), DialogView {

    @InjectPresenter
    lateinit var presenter: DialogPresenter

    override fun showCount(count: Int) {
        Toast.makeText(activity, "count = $count", Toast.LENGTH_SHORT).show()
    }

    val compositeDisposeble = CompositeDisposable()

    val disposableObserver = object : DisposableObserver<String?>() {
        override fun onComplete() {

        }

        override fun onNext(t: String) {
            Toast.makeText(activity, t, Toast.LENGTH_SHORT).show()
            (activity as TestActivity).presenter.addBarcode(t)
        }

        override fun onError(e: Throwable) {
            Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDetach() {
        super.onDetach()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.barcode_dialog_fg, container, false)
        view.btnDone.setOnClickListener {
            var str = (activity as TestActivity).presenter.list.joinToString("\n")
            Toast.makeText(activity, str, Toast.LENGTH_SHORT).show()
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as TestActivity).presenter.barcodePublishSubject.subscribe(disposableObserver)
    }

    override fun onStop() {
        super.onStop()
        disposableObserver.dispose()
    }

}