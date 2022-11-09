package com.example.fcm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ShoppingItem::class],
    version = 2
)
 abstract class ShoppingDatabase : RoomDatabase() {
     abstract fun shoppingDao() : ShoppingDao
}