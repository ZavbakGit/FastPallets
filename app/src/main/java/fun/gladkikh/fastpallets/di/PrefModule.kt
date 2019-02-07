package `fun`.gladkikh.fastpallets.di

import android.content.Context
import com.gladkikh.preference.IPreferenceHelper
import com.gladkikh.preference.PreferenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PrefModule {
    @Provides @Singleton
    fun providePreferenceHelper(context: Context): PreferenceHelper = IPreferenceHelper(context)
}