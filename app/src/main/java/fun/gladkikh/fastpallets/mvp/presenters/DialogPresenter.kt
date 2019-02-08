package `fun`.gladkikh.fastpallets.mvp.presenters


import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter


@InjectViewState
class DialogPresenter: MvpPresenter<DialogView>() {

    var count:Int = 0

    fun setCount(s:Int?) {
        count = count + s!!

        viewState.showCount(count)

    }



    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}