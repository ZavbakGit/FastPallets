package `fun`.gladkikh.fastpallets.mvp.presenters

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface MainMenuView:MvpView {
    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun startCreatePalleteModule()

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun startPreferenceModule()

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun startTestActivity()
}