package `fun`.gladkikh.fastpallets.mvp.presenters

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import ru.terrakok.cicerone.Router

open abstract class BasePresenter<V : MvpView>(val router: Router) : MvpPresenter<V>() {

    open fun onBackPressed(): Boolean {
        router.backTo(null)
        return true
    }
}


