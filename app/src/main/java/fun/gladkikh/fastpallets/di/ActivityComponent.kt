package `fun`.gladkikh.fastpallets.di


import `fun`.gladkikh.fastpallets.TestActivity
import dagger.Subcomponent



@Subcomponent(
    modules = arrayOf(
       ActivityModule::class
    )
)
@ActivityScope
interface ActivityComponent {
    fun inject(testActivity: TestActivity)
}


