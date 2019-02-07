package `fun`.gladkikh.fastpallets.mvp.presenters

import `fun`.gladkikh.fastpallets.di.App
import `fun`.gladkikh.fastpallets.mvp.model.EnumMenu
import `fun`.gladkikh.fastpallets.navigate.Screens
import android.content.Context
import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainMenuFgPresenter(val router: Router) : BasePresenter<MainMenuView>() {

    @Inject
    lateinit var screens: Screens

    init {
        App.appComponent.inject(this)
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun clickItemMenu(position: Int) {
        val item = EnumMenu.values().toList()[position]
        when(item){
            EnumMenu.CREATE_PALETTE -> viewState.startCreatePalleteModule()
            EnumMenu.SETTINGS-> viewState.startPreferenceModule()
            EnumMenu.TESTS->viewState.startTestActivity()
        }
    }

    fun pressKey(number: Char) {

    }

    fun startTestActivity(activity: Context) {
        router.navigateTo(screens.getTestActivity())
    }

    fun startPreferenceModule(activity: Context) {
        router.navigateTo(screens.getPreferencesScreen())
    }

    fun startCreateMenuModule(activity: Context) {
       //router.navigateTo(Screens.StartCreatePalletScreen)
    }

    fun getListMenu(): List<EnumMenu> {
        return EnumMenu.values().toList()
    }
}