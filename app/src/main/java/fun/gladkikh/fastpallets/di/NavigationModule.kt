package `fun`.gladkikh.fastpallets.di

import `fun`.gladkikh.fastpallets.navigate.Screens
import com.gladkikh.preference.PreferenceHelper
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * Created by agladkov on 22.12.17.
 * Dagger module provides navigator and router for Cicerone
 */
@Module
class NavigationModule {
    private var cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    @Singleton
    fun provideNavigationHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }

    @Provides
    @Singleton
    fun provideScreens(preferenceHelper: PreferenceHelper): Screens {
        return Screens(preferenceHelper)
    }
}