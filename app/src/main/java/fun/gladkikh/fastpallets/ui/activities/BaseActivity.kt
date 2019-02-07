package `fun`.gladkikh.fastpallets.ui.activities

import `fun`.gladkikh.fastpallets.di.App
import `fun`.gladkikh.fastpallets.navigate.BackButtonListener
import `fun`.gladkikh.fastpallets.navigate.RouterProvider
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject

abstract class BaseActivity:MvpAppCompatActivity(), RouterProvider {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var routerMain: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(getNavigator())
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(getIdConteiner())
        if (fragment != null && fragment is BackButtonListener && fragment.onBackPressed()) {
            return
        } else {
            backTo()
        }
    }

    override fun getRouter() = routerMain

    abstract fun backTo()
    abstract fun getIdConteiner(): Int
    abstract fun getNavigator(): Navigator
    abstract fun getLayout(): Int

}