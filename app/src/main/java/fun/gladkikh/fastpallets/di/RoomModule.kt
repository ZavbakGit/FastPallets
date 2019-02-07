package `fun`.gladkikh.fastpallets.di

import android.content.Context
import com.gladkikh.database.common.RoomAppDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

  @Provides @Singleton fun provideRoomCurrencyDataSource(context: Context) =
      RoomAppDataSource.buildDataSource(context)
}


