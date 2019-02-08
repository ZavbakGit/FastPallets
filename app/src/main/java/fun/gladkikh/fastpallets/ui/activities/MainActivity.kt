package `fun`.gladkikh.fastpallets.ui.activities

import `fun`.gladkikh.fastpallets.R
import `fun`.gladkikh.fastpallets.mvp.presenters.MainActivityPresenter
import `fun`.gladkikh.fastpallets.mvp.presenters.MainView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : BaseActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    @ProvidePresenter
    fun provideMainPresenter(): MainActivityPresenter {
        return MainActivityPresenter(getRouter())
    }

    override fun backTo() {
        presenter.onBackPressed()
    }

    override fun getIdConteiner()= R.id.conteiner_frame
    override fun getNavigator() = SupportAppNavigator(this, getIdConteiner())
    override fun getLayout() = R.layout.activity_main

}
