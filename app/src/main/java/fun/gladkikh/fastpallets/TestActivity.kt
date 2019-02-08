package `fun`.gladkikh.fastpallets

import `fun`.gladkikh.fastpallets.di.App
import `fun`.gladkikh.fastpallets.helpers.DialogReadBarcodeHelper
import `fun`.gladkikh.fastpallets.mvp.presenters.TestActivityPresenter
import `fun`.gladkikh.fastpallets.mvp.view.TestActivityView
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.gladkikh.mylibrary.BarcodeHelper
import com.gladkikh.netreqest.NetHelper
import com.gladkikh.preference.IPreferenceHelper
import com.gladkikh.preference.PreferenceHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.test_activity_main.*
import javax.inject.Inject


class TestActivity : MvpAppCompatActivity(), TestActivityView {

    @InjectPresenter
    lateinit var presenter: TestActivityPresenter


    @Inject
    lateinit var prefHelper: PreferenceHelper

    @Inject
    lateinit var nethelper: NetHelper

    @Inject
    lateinit var appContext: Context

    @Inject
    lateinit var barcodeHelper: BarcodeHelper

    @Inject
    lateinit var barcodeDialogReadBarcodeHelper: DialogReadBarcodeHelper


    override fun onCreate(savedInstanceState: Bundle?) {

        App.getActivityComponent(this).inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity_main)


        tv_barcode_dialog.setOnClickListener {
            barcodeDialogReadBarcodeHelper.showDialog()
        }


        tv_hello.setOnClickListener {
            prefHelper = IPreferenceHelper(this)
            startActivity(prefHelper.getIntentPreferenceActivity())
        }

        tv_show_pref.setOnClickListener {
            Toast.makeText(
                this@TestActivity,
                "${prefHelper.getHost()} \n ${prefHelper.getLogin()} \n ${prefHelper.getPass()}",
                Toast.LENGTH_SHORT
            ).show()
        }


        tv_rest_show.setOnClickListener {
            nethelper.getObservable()
                .subscribeOn(Schedulers.io()) //делаем запрос, преобразование, кэширование в отдельном потоке
                .observeOn(AndroidSchedulers.mainThread()) // обработка результата - в main thread
                .subscribe({ result ->
                    Toast.makeText(
                        this@TestActivity,
                        result.docsListCount,
                        Toast.LENGTH_SHORT
                    ).show()
                },
                    { error ->
                        Toast.makeText(
                            this@TestActivity,
                            error.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    })

        }

        tv_show_pallet.setOnClickListener {

        }


    }


}



