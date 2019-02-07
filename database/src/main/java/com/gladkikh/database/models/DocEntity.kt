package com.gladkikh.database.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.gladkikh.database.common.RoomContract


@Entity(tableName = RoomContract.TABLE_DOC)
data class DocEntity(@PrimaryKey val guid: String, val number: String, val date:String)