package `fun`.gladkikh.fastpallets.navigate

import `fun`.gladkikh.fastpallets.TestActivity
import `fun`.gladkikh.fastpallets.ui.fragments.BaseScreenFragment
import `fun`.gladkikh.fastpallets.ui.fragments.MainMenuScreenFragment
import `fun`.gladkikh.fastpallets.ui.fragments.PalletFragment
import android.content.Context
import android.content.Intent
import com.gladkikh.preference.PreferenceHelper
import ru.terrakok.cicerone.android.support.SupportAppScreen


class Screens(private val preferenceHelper: PreferenceHelper) {

    fun getMainMenuScreen(): SupportAppScreen {
        return object : SupportAppScreen() {
            override fun getFragment() = MainMenuScreenFragment.newInstance()
        }
    }

    fun getPalletScreen(): SupportAppScreen {
        return object : SupportAppScreen() {
            override fun getFragment() = PalletFragment.newInstance()
        }
    }

    fun getTestActivity(): SupportAppScreen {
        return object : SupportAppScreen() {
            override fun getActivityIntent(context: Context?): Intent {
                return Intent(context, TestActivity::class.java)
            }
        }
    }

    fun getPreferencesScreen(): SupportAppScreen {
        return object : SupportAppScreen() {
            override fun getActivityIntent(context: Context?): Intent {
                return preferenceHelper.getIntentPreferenceActivity()
            }
        }
    }
}