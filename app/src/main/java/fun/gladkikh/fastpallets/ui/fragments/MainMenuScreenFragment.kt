package `fun`.gladkikh.fastpallets.ui.fragments

import `fun`.gladkikh.fastpallets.R
import `fun`.gladkikh.fastpallets.mvp.presenters.BasePresenter
import `fun`.gladkikh.fastpallets.mvp.presenters.MainMenuFgPresenter
import `fun`.gladkikh.fastpallets.mvp.presenters.MainMenuView
import `fun`.gladkikh.fastpallets.navigate.RouterProvider
import `fun`.gladkikh.fastpallets.ui.adapters.ListMenuAdapter
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.main_menu_screen.*

class MainMenuScreenFragment : BaseScreenFragment(), MainMenuView {

    @InjectPresenter
    lateinit var presenter: MainMenuFgPresenter

    companion object {
        fun newInstance(): MainMenuScreenFragment {
            return BaseScreenFragment.newInstance(MainMenuScreenFragment(),
                "main_menu_screen_fragment",null) as MainMenuScreenFragment
        }
    }

    @ProvidePresenter
    fun provideMainPresenter(): MainMenuFgPresenter {
        return MainMenuFgPresenter((activity as RouterProvider).getRouter())
    }

    override fun startTestActivity() {
        presenter.startTestActivity(activity as Context)
    }
    override fun startPreferenceModule() {
       presenter.startPreferenceModule(activity as Context)
    }
    override fun startPallet() {
        presenter.startPallet(activity as Context)
    }
    override fun startCreatePalleteModule() {
        presenter.startCreateMenuModule(activity as Context)
    }



    override fun onStart() {
        super.onStart()
        lv_menu_screen_list.adapter = ListMenuAdapter(activity, presenter.getListMenu())

        lv_menu_screen_list.requestFocus(0)
        lv_menu_screen_list.setSelection(0)
        lv_menu_screen_list.setClickable(true)

        lv_menu_screen_list.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, position, id ->
                    presenter.clickItemMenu(
                        position
                    )
                }

        lv_menu_screen_list.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {

                if (event.action == KeyEvent.ACTION_DOWN) {
                    presenter.pressKey(event.number)
                }
                return false
            }
        })


    }
    override fun getRouter() = (activity as RouterProvider).getRouter()
    override fun getLayout() = R.layout.main_menu_screen
    override fun onBackPressed() = presenter.onBackPressed()
    override fun getPresenter() = presenter as BasePresenter<MvpView>
}