package `fun`.gladkikh.fastpallets.mvp.presenters

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface DialogView:MvpView {
    @StateStrategyType(value = SkipStrategy::class)
    fun showCount(count: Int)
}