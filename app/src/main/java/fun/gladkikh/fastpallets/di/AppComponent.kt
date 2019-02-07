package `fun`.gladkikh.fastpallets.di

import `fun`.gladkikh.fastpallets.mvp.presenters.MainMenuFgPresenter
import `fun`.gladkikh.fastpallets.mvp.presenters.MainActivityPresenter
import `fun`.gladkikh.fastpallets.navigate.Screens
import `fun`.gladkikh.fastpallets.ui.activities.BaseActivity
import com.gladkikh.preference.PreferenceHelper
import dagger.Component

import javax.inject.Singleton

@Component(
    modules = arrayOf(
        AppModule::class,
        NavigationModule::class,
        LocalNavigationModule::class,
        RoomModule::class,
        PrefModule::class
    )
)
@Singleton
interface AppComponent {
    fun createActivityComponent(activityModule:ActivityModule):ActivityComponent
    fun providePreferenceHelper(): PreferenceHelper
    fun inject(baseActivity: BaseActivity)
    fun inject(presenter: MainMenuFgPresenter)
    fun inject(screens: Screens)
    fun inject(mainPresenter: MainActivityPresenter)
}


