package `fun`.gladkikh.fastpallets.ui.fragments

import `fun`.gladkikh.fastpallets.R
import `fun`.gladkikh.fastpallets.mvp.presenters.BasePresenter
import `fun`.gladkikh.fastpallets.mvp.presenters.MainMenuFgPresenter
import `fun`.gladkikh.fastpallets.mvp.presenters.PalletFrPresenter
import `fun`.gladkikh.fastpallets.mvp.view.PalletView
import `fun`.gladkikh.fastpallets.navigate.RouterProvider
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

class PalletFragment: BaseScreenFragment(), PalletView {
    @InjectPresenter
    lateinit var presenter:PalletFrPresenter

    @ProvidePresenter
    fun provideMainPresenter(): PalletFrPresenter {
        return PalletFrPresenter((activity as RouterProvider).getRouter())
    }

    companion object {
        fun newInstance(): PalletFragment {
            return BaseScreenFragment.newInstance(PalletFragment(),
                "pallet_screen_fragment",null) as PalletFragment
        }
    }



    override fun getRouter() = (activity as RouterProvider).getRouter()
    override fun getLayout() = R.layout.pallet_fragment
    override fun getPresenter() =  presenter as BasePresenter<MvpView>
}