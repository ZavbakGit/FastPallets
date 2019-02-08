package `fun`.gladkikh.fastpallets.mvp.presenters

import `fun`.gladkikh.fastpallets.di.App
import `fun`.gladkikh.fastpallets.navigate.Screens
import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter(router: Router) :BasePresenter<MainMenuView>(router) {

    @Inject
    lateinit var screens: Screens

    init {
        App.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.getMainMenuScreen())
    }

}