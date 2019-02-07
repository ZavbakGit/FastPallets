package com.gladkikh.database.common

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.gladkikh.database.models.DocEntity


@Database(entities = arrayOf(DocEntity::class), version = 1, exportSchema = false)
abstract class RoomAppDataSource : RoomDatabase() {
    abstract fun productsDao(): ProductsDao

    companion object {
        private val TAG = RoomAppDataSource::class.java.simpleName

        fun buildDataSource(context: Context): RoomAppDataSource = Room.databaseBuilder(
            context.applicationContext, RoomAppDataSource::class.java, RoomContract.DATABASE_APP
        )
            .fallbackToDestructiveMigration()
            .build()
    }

}