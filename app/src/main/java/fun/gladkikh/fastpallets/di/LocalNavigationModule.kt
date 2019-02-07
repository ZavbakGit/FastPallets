package `fun`.gladkikh.fastpallets.di

import `fun`.gladkikh.fastpallets.navigate.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by agladkov on 08.02.18.
 */
@Module
class LocalNavigationModule {

    @Provides
    @Singleton
    fun provideLocalNavigationHolder(): LocalCiceroneHolder {
        return LocalCiceroneHolder()
    }
}
