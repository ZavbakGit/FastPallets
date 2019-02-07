package `fun`.gladkikh.fastpallets.di


import android.support.v7.app.AppCompatActivity
import com.gladkikh.mylibrary.BarcodeHelper
import com.gladkikh.mylibrary.IBarcodeHelper
import com.gladkikh.netreqest.NetHelper
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity: AppCompatActivity) {
    @ActivityScope
    @Provides
    fun provideBarcodeHelper(): BarcodeHelper = IBarcodeHelper(activity)

    @ActivityScope
    @Provides
    fun provideNetHelper(): NetHelper = NetHelper(
        App.appComponent.providePreferenceHelper().getHost(),
        App.appComponent.providePreferenceHelper().getLogin(),
        App.appComponent.providePreferenceHelper().getPass()
    )

//    @ActivityScope
//    @Provides
//    fun provideDialogReadBarcodeHelper(): DialogReadBarcodeHelper = DialogReadBarcodeHelper(activity)

}


