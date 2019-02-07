package `fun`.gladkikh.fastpallets.di

import android.app.Activity
import android.app.Application
import android.support.v7.app.AppCompatActivity

open class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent

        fun getActivityComponent(activity: AppCompatActivity): ActivityComponent =
            appComponent.createActivityComponent(ActivityModule(activity))

    }


    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }


    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(app = this@App))
            .roomModule(RoomModule())
            .build()
    }

}

