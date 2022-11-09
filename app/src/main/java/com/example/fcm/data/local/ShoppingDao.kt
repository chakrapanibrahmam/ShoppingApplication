package com.example.fcm.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface ShoppingDao {

    @Insert
     suspend fun  insertShoppingItem(shoppingItem : List<ShoppingItem>)

     @Delete
     suspend fun deleterShoppingItem(ShoppingItem : List<ShoppingItem>)

     @Query("SELECT * FROM shopping_items")
     fun observerShoppingItem (): LiveData<List<ShoppingItem>>

     @Query("SELECT SUM(price * amount) FROM SHOPPING_ITEMS")
     fun observerTotalPrice() : LiveData<Float>
}