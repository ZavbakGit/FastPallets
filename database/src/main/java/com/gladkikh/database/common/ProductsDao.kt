package com.gladkikh.database.common


import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.gladkikh.database.models.DocEntity


@Dao
interface ProductsDao {

    // Get app configuration (can be expanded in future)
    @Query("SELECT * FROM " + RoomContract.TABLE_DOC)
    fun getDocs(): List<DocEntity>

    // Add or update configuration in DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateDocs(vararg productEntity: DocEntity)

    @Query("DELETE FROM " + RoomContract.TABLE_DOC)
    fun deleteDocsAll()
}